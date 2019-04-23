package com.awsm.forecastapp.di.module

import android.app.Application
import com.awsm.forecastapp.data.ApiService
import com.awsm.forecastapp.data.util.LiveDataCallAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import java.security.cert.CertificateException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
class NetworkModule {

	@Provides
	@Singleton
	fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
		val interceptor = HttpLoggingInterceptor(
			HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
		interceptor.level = HttpLoggingInterceptor.Level.BODY
		return interceptor
	}

	@Provides
	@Singleton
	fun provideCache(cacheFile: File): Cache {
		return Cache(cacheFile, 10 * 1000 * 1000)
	}

	@Provides
	@Singleton
	fun provideCacheFile(application: Application): File {
		return File(application.cacheDir, "OkHttpCache")
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(
		httpLoggingInterceptor: HttpLoggingInterceptor,
		cache: Cache
	): OkHttpClient {
		val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
			@Throws(CertificateException::class)
			override fun checkClientTrusted(
				chain: Array<java.security.cert.X509Certificate>,
				authType: String
			) {
			}

			@Throws(CertificateException::class)
			override fun checkServerTrusted(
				chain: Array<java.security.cert.X509Certificate>,
				authType: String
			) {
			}

			override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
				return arrayOf()
			}
		})
		val sslContext = SSLContext.getInstance("SSL")
		sslContext.init(null, trustAllCerts, java.security.SecureRandom())
		val sslSocketFactory = sslContext.socketFactory

		val builder = OkHttpClient.Builder()
		builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
		builder.hostnameVerifier { _, _ -> true }
		builder.addInterceptor(httpLoggingInterceptor)
		builder.cache(cache)
		builder.connectTimeout(2, TimeUnit.MINUTES)
		builder.readTimeout(2, TimeUnit.MINUTES)
		return builder.build()
	}

//	@Provides
//	@Singleton
//	fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
//		return OkHttpClient
//				.Builder()
//				.addInterceptor(httpLoggingInterceptor)
//				.cache(cache)
//				.connectTimeout(2, TimeUnit.MINUTES)
//				.readTimeout(2, TimeUnit.MINUTES)
//				.build()
//	}

	@Provides
	@Singleton
	fun provideGson(): Gson {
		return GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
			.create()
	}

	@Provides
	@Singleton
	fun provideRetrofit(
		okHttpClient: OkHttpClient,
		gson: Gson
	): Retrofit {
		return Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create(gson))
			.addCallAdapterFactory(LiveDataCallAdapterFactory())
			.client(okHttpClient)
			.baseUrl(ApiService.baseUrl)
			.build()
	}
}