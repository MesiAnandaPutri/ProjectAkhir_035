package com.example.projectakhir.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.modeldata.DataProduk
import com.example.projectakhir.repositori.RepositoriDataProduk
import kotlinx.coroutines.launch
import java.io.IOException

// UI State untuk halaman Home
data class HomeUIState(
    val listProduk: List<DataProduk> = listOf(),
    // Tambahkan state lain di sini jika perlu (misal: jumlah transaksi, pendapatan)
)

class HomeViewModel(private val repositoriDataProduk: RepositoriDataProduk) : ViewModel() {

    var homeUIState by mutableStateOf(HomeUIState())
        private set

    init {
        // Langsung panggil fungsi untuk mengambil data produk saat ViewModel dibuat
        getProduk()
    }

    fun getProduk() {
        viewModelScope.launch {
            try {
                // Mengambil data dari repositori dan memperbarui UI state
                homeUIState = homeUIState.copy(
                    listProduk = repositoriDataProduk.getProduk()
                )
            } catch (e: IOException) {
                // Handle error (misalnya tampilkan pesan atau state error)
                e.printStackTrace()
            }
        }
    }
}
