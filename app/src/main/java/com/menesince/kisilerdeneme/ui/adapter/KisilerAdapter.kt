package com.menesince.kisilerdeneme.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.menesince.kisilerdeneme.R
import com.menesince.kisilerdeneme.data.entity.Kisiler
import com.menesince.kisilerdeneme.databinding.CardTasarimBinding
import com.menesince.kisilerdeneme.ui.fragment.AnasayfaFragment
import com.menesince.kisilerdeneme.ui.fragment.AnasayfaFragmentDirections
import com.menesince.kisilerdeneme.ui.viewmodel.AnasayfaViewModel

class KisilerAdapter (var mContext : Context, var kisiListesi : List<Kisiler>, var viewModel: AnasayfaViewModel) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {


    inner class CardTasarimTutucu (var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding: CardTasarimBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisiListesi.get(position)
        val t = holder.tasarim

        t.kisi = kisi

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.guncelleGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }


        t.imageButtonSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    viewModel.sil(kisi.id)

                }
                .show()
        }


    }

    override fun getItemCount(): Int {
        return kisiListesi.size
    }




}