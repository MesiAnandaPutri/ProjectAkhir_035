package com.example.projectakhir.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class DataProduk(
    val produk_id: Int,
    val produk_name: String,
    val kategori: String,
    val unit: String,
    val stock_qty: Int,
    val harga: Int,
    val deskripsi: String?, // Nullable karena constraint-nya "Null"
    val img_path: String
)

data class UIStateProduk(
    val detailProduk: DetailProduk = DetailProduk(),
    val isEntryValid: Boolean = false
)

data class DetailProduk(
    val produk_id: Int = 0,
    val produk_name: String = "",
    val kategori: String = "",
    val unit: String = "",
    val stock_qty: Int = 0,
    val harga: Int = 0,
    val deskripsi: String? = null, // Nullable
    val img_path: String = ""
)

fun DetailProduk.toDataProduk(): DataProduk = DataProduk(
    produk_id = produk_id,
    produk_name = produk_name,
    kategori = kategori,
    unit = unit,
    stock_qty = stock_qty,
    harga = harga,
    deskripsi = deskripsi,
    img_path = img_path
)

fun DataProduk.toUiStateProduk(isEntryValid: Boolean = false): UIStateProduk = UIStateProduk(
    detailProduk = this.toDetailProduk(),
    isEntryValid = isEntryValid
)

fun DataProduk.toDetailProduk(): DetailProduk = DetailProduk(
    produk_id = produk_id,
    produk_name = produk_name,
    kategori = kategori,
    unit = unit,
    stock_qty = stock_qty,
    harga = harga,
    deskripsi = deskripsi,
    img_path = img_path
)
