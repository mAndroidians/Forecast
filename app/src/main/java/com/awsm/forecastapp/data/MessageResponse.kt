package com.awsm.forecastapp.data

import com.google.gson.annotations.SerializedName

data class MessageResponse(
	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("Id")
	val id: Int?,

	@field:SerializedName("appointmentId")
	val appointmentId: Long?
)