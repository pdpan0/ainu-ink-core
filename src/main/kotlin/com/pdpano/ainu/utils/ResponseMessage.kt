package com.pdpano.ainu.utils

data class ResponseMessage(
    val code: Int,
    val type: String,
    val message: String,
    val objectId: String?,
)