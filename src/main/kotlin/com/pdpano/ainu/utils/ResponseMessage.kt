package com.pdpano.ainu.utils

data class ResponseMessage(
    val success: Boolean,
    val type: String,
    val message: String,
    val objectId: String?,
)