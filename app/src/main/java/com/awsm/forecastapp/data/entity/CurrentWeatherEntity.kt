package com.awsm.forecastapp.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "current_weather_table"
)

data class CurrentWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id:Int?,
    @Embedded
    @field:SerializedName("location")
    val location: Location,
    @Embedded
    @field:SerializedName("current")
    val current: Current){

    data class Location(
        @field:SerializedName("name")
        val name : String?,
        @field:SerializedName("region")
        val region:String?,
        @field:SerializedName("country")
        val country : String?,
        @field:SerializedName("lat")
        val latitude : Double?,
        @field:SerializedName("lon")
        val longitude : Double?,
        @field:SerializedName("tz_id")
        val tz_id:String?,
        @field:SerializedName("localtime_epoch")
        val localtime_epoch:Long?,
        @field:SerializedName("localtime")
        val localtime:String?
    )

    data class Current(
        @field:SerializedName("last_updated_epoch")
        val last_updated_epoch:Long?,
        @field:SerializedName("last_updated")
        val last_updated:String?,
        @field:SerializedName("temp_c")
        val temp_c:Double?,
        @field:SerializedName("temp_f")
        val temp_f:Double?,
        @field:SerializedName("is_day")
        val is_day:Int?,
        @Embedded
        @field:SerializedName("condition")
        val condition : ConditionC?,
        @field:SerializedName("wind_mph")
        val wind_mph : Double?,
        @field:SerializedName("wind_kph")
        val wind_kph:Double?,
        @field:SerializedName("wind_degree")
        val wind_degree:Int?,
        @field:SerializedName("wind_dir")
        val wind_dir:String?,
        @field:SerializedName("pressure_mb")
        val pressure_mb:Int?,
        @field:SerializedName("pressure_in")
        val pressure_in:Double?,
        @field:SerializedName("precip_mm")
        val precip_mm:Int?,
        @field:SerializedName("precip_in")
        val precip_in:Int?,
        @field:SerializedName("humidity")
        val humidity:Int?,
        @field:SerializedName("cloud")
        val cloud:Int?,
        @field:SerializedName("feelslike_c")
        val feelslike_c:Double?,
        @field:SerializedName("feelslike_f")
        val feelslike_f:Double?,
        @field:SerializedName("vis_km")
        val vis_km:Double?,
        @field:SerializedName("vis_miles")
        val vis_miles:Int?,
        @field:SerializedName("uv")
        val uv:Int?,
        @field:SerializedName("gust_mph")
        val gust_mph:Double?,
        @field:SerializedName("gust_kph")
        val gust_kph:Int?

    )
    data class ConditionC(
        @field:SerializedName("text")
        val text:String?,
        @field:SerializedName("icon")
        val icon:String?,
        @field:SerializedName("code")
        val code:Int?
    )
}