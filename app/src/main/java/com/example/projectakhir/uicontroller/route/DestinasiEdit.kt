package com.example.projectakhir.uicontroller.route

// PERBAIKAN: Import R dari package aplikasi Anda
import com.example.projectakhir.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "edit_produk"
    // Pastikan Anda telah menambahkan <string name="edit_produk">Edit Produk</string> di dalam res/values/strings.xml
    override val titleRes = R.string.edit_produk
    const val produkIdArg = "produkId"
    val routeWithArgs = "$route/{$produkIdArg}"
}
