package com.bigrocket.limpezaapp.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.model.Address
import com.bigrocket.limpezaapp.model.Schedule
import kotlinx.android.synthetic.main.res_item_list.view.*

class ListServiceAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var listService: List<Schedule>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListServiceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ListServiceViewHolder -> {
                holder.bind(listService[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listService.size
    }

    fun setDataSet(list: List<Schedule>) {
        listService = list
    }

    class ListServiceViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val typeService = itemView.textViewTypeService
        private val dateService = itemView.textViewDate
        private val addressService = itemView.textViewAddess

        fun bind(schedule: Schedule) {
            typeService.text = schedule.typeService
            dateService.text = schedule.date
            addressService.text = concatenate(schedule.address)
        }
        fun concatenate(address: Address) : String {
            return "${address.logradouro}," +
                    "${address.number} - " +
                    "${address.district}, " +
                    "${address.city} - " +
                    "${address.state} / " +
                    "${address.country}"
        }
    }
}