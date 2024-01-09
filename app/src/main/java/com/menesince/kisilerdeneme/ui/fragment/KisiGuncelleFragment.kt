package com.menesince.kisilerdeneme.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.menesince.kisilerdeneme.R
import com.menesince.kisilerdeneme.databinding.FragmentKisiGuncelleBinding
import com.menesince.kisilerdeneme.ui.viewmodel.KisiGuncelleViewModel
import com.menesince.kisilerdeneme.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiGuncelleFragment : Fragment() {
    private lateinit var binding: FragmentKisiGuncelleBinding
    private lateinit var viewModel: KisiGuncelleViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_guncelle ,container, false)
        binding.kisiGuncelleFragmentNesnesi = this

        binding.kisiGuncelleToolbar = "Güncelle"

        val bundle : KisiGuncelleFragmentArgs by navArgs()
        val gelen_kisi = bundle.kisi
        binding.kisi = gelen_kisi
        return binding.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiGuncelleViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) {
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }
}