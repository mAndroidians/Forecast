package com.awsm.forecastapp.util

import android.app.Application
import android.content.Context
import androidx.annotation.WorkerThread

class SharedPreferencesUtility(
	private val context: Application
) {

	companion object {
		const val USER_TYPE = "USER_TYPE"
		const val TOKEN = "TOKEN"
		const val USER_ID = "USER_ID"
		const val S3URL = "S3URL"
	}

	fun getPrefInt(key: String): Int {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getInt(key, 0)
	}

	fun savePrefInt(
		key: String,
		value: Int
	) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putInt(key, value)
			.apply()
	}

	fun getPrefBoolean(key: String): Boolean {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getBoolean(key, false)
	}

	fun savePrefBoolean(
		key: String,
		value: Boolean
	) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putBoolean(key, value)
			.apply()
	}

	fun getPrefLong(key: String): Long {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getLong(key, 0)
	}

	fun savePrefLong(
		key: String,
		value: Long
	) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putLong(key, value)
			.apply()
	}

	fun getPrefString(key: String): String {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getString(key, "") ?: ""
	}

	fun savePrefString(
		key: String,
		value: String
	) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putString(key, value)
			.apply()
	}

	fun getS3Url(): String {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getString(S3URL, "") ?: ""
	}

	fun saveS3Url(value: String) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putString(S3URL, value)
			.apply()
	}

	fun getToken(): String {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getString(TOKEN, "") ?: ""
	}

	fun saveToken(value: String) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putString(TOKEN, value)
			.apply()
	}

	fun getUserId(): String {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		return prefs.getString(USER_ID, "") ?: ""
	}

	fun saveUserId(value: String) {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.putString(USER_ID, value)
			.apply()
	}

	@WorkerThread
	fun clearSharedPref() {
		val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
		prefs.edit()
			.clear()
			.apply()
	}
}