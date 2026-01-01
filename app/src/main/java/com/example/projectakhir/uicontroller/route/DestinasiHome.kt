package com.example.projectakhir.uicontroller.route

import com.example.projectakhir.R

/**
 * Mendefinisikan rute dan judul untuk Halaman Home.
 */
object DestinasiHome : DestinasiNavigasi {
    // Nama unik untuk rute ke halaman home
    override val route = "home"
    // Referensi ke resource string untuk judul halaman (misalnya "Dashboard")
    override val titleRes = R.string.app_name // Atau string lain yang sesuai
}
