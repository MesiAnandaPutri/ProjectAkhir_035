package com.example.projectakhir.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val username: String,
    val password: String,
    val user_role: String
)

@Serializable
data class BaseResponse(
    val success: Boolean,
    val message: String
)