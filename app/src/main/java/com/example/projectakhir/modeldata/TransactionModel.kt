package com.example.projectakhir.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class TransactionRequest(
    val produk_id: Int,
    val user_id: Int,
    val qty_out: Int
)

@Serializable
data class TransactionResponse(
    val success: Boolean,
    val message: String
)