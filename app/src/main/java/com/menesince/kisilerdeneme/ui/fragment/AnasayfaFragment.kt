package com.menesince.kisilerdeneme.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.menesince.kisilerdeneme.R
import com.menesince.kisilerdeneme.data.entity.Kisiler
import com.menesince.kisilerdeneme.databinding.FragmentAnasayfaBinding
import com.menesince.kisilerdeneme.ui.adapter.KisilerAdapter
import com.menesince.kisilerdeneme.ui.viewmodel.AnasayfaViewModel
import com.menesince.kisilerdeneme.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)
        binding.anasayfaFragmentNesnesi = this

       binding.anasayfaToolbar= "Kişiler"

        viewModel.kisilerListesi.observe(viewLifecycleOwner) {
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = kisilerAdapter
        }
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean { // harf girdikçe,sildikçe sonuç getiren fonksiyon

                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { // klavye de arama ikonuna basınca getiren

                viewModel.ara(query)
                return true
            }


        })
        return binding.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriGoster()
    }

    fun buttonFab(it : View) {
        Navigation.findNavController(it).navigate(R.id.kayitGecis)
    }

}