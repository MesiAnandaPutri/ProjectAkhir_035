package com.example.projectakhir.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.repositori.RepositoriDataProduk
import kotlinx.coroutines.launch
import java.io.IOException

data class LoginUIState(
    val email: String = "",
    val pass: String = ""
)

// --- KESALAHAN #1: ViewModel belum menerima repositori ---
// PERBAIKAN: Tambahkan repositori di constructor
class LoginViewModel(private val repositoriDataProduk: RepositoriDataProduk) : ViewModel() {

    var loginUIState by mutableStateOf(LoginUIState())
        private set

    fun updateLoginUIState(inputState: LoginUIState) {
        loginUIState = inputState
    }

    // --- FUNGSI BARU UNTUK PROSES LOGIN ---
    fun tryLogin(onSuccess: () -> Unit, onError: (String) -> Unit) {
        if (!validasiInput()) {
            onError("Email dan Password tidak boleh kosong.")
            return
        }

        viewModelScope.launch {
            try {
                // Di dunia nyata, Anda akan memanggil API login di sini.
                // Untuk sekarang, kita anggap login selalu berhasil jika input valid.
                // val loginRequest = LoginRequest(username = loginUIState.email, pass = loginUIState.pass)
                // repositoriDataProduk.login(loginRequest) // Baris ini akan dipakai jika API login ada

                // Panggil callback sukses untuk navigasi
                onSuccess()

            } catch (e: IOException) {
                onError("Gagal terhubung ke server.")
            } catch (e: Exception) {
                onError("Login gagal: ${e.message}")
            }
        }
    }

    fun validasiInput(email: String = loginUIState.email, password: String = loginUIState.pass): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }
}
