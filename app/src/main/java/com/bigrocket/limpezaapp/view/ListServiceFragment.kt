package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.resource.DataSourceSchedule
import com.bigrocket.limpezaapp.resource.ListServiceAdapter
import kotlinx.android.synthetic.main.fragment_list_service.*

class ListServiceFragment : Fragment(R.layout.fragment_list_service) {

    // Nome da variável deve ser diferente de somente adapter como está no vídeo
    // O Kotlin não consegue distinguir o que é variável e o que é propriedade do RecyclerView
    private lateinit var listAdapter: ListServiceAdapter
    private val args: ListServiceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        populateRecycler()
    }

    private fun initAdapter() {
        listAdapter = ListServiceAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
    }

    private fun populateRecycler() {
        DataSourceSchedule.createSchedule(args.schedule) {
            listAdapter.setDataSet(it)
        }
    }
}