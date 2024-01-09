package com.menesince.kisilerdeneme.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.menesince.kisilerdeneme.data.entity.Kisiler
import com.menesince.kisilerdeneme.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AnasayfaViewModel @Inject constructor ( var kRepo : KisilerRepository) : ViewModel() {


    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriGoster()
    }
    fun kisileriGoster() {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kRepo.kisileriGoster()
        }
    }

    fun sil(kisi_id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.sil(kisi_id)
            kisileriGoster()
        }
    }

    fun ara(aramaKelimesi : String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kRepo.ara(aramaKelimesi)
        }
    }
}