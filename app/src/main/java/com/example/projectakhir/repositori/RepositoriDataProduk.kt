package com.example.projectakhir.repositori


import com.example.projectakhir.apiservice.ServiceApiKatalog
import com.example.projectakhir.modeldata.DataProduk

// Interface untuk Repositori Produk
interface RepositoriDataProduk {
    suspend fun getProduk(): List<DataProduk>
    suspend fun postProduk(dataProduk: DataProduk)
    suspend fun getSatuProduk(id: Int): DataProduk
    suspend fun editSatuProduk(id: Int, dataProduk: DataProduk)
    suspend fun hapusSatuProduk(id: Int)
}

// Implementasi Repositori yang mengambil data dari network
class NetworkRepositoriDataProduk(
    private val serviceApiKatalog: ServiceApiKatalog
) : RepositoriDataProduk {
    override suspend fun getProduk(): List<DataProduk> = serviceApiKatalog.getProduk()
    override suspend fun postProduk(dataProduk: DataProduk) {
        serviceApiKatalog.postProduk(dataProduk)
    }
    override suspend fun getSatuProduk(id: Int): DataProduk = serviceApiKatalog.getSatuProduk(id)
    override suspend fun editSatuProduk(id: Int, dataProduk: DataProduk) {
        serviceApiKatalog.editSatuProduk(id, dataProduk)
    }
    override suspend fun hapusSatuProduk(id: Int) {
        serviceApiKatalog.hapusSatuProduk(id)
    }
}
