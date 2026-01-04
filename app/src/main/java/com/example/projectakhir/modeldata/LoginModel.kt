package com.example.projectakhir.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)

@Serializable
data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: UserData? = null
)

@Serializable
data class UserData(
    val user_id: Int,
    val username: String,
    val role: String
)