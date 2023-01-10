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

    private lateinit var adapter: ListServiceAdapter
    private val args: ListServiceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        populateRecycler()
    }

    private fun initAdapter() {
        adapter = ListServiceAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
    }

    private fun populateRecycler() {
        DataSourceSchedule.createSchedule(args.schedule) {
            adapter.setDataSet(it)
        }
    }
}