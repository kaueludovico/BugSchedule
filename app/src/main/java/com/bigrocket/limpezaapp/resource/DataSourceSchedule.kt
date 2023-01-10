package com.bigrocket.limpezaapp.resource

import com.bigrocket.limpezaapp.model.Schedule

class DataSourceSchedule {
    companion object {
        fun createSchedule(schedule: Schedule, callback: (list: ArrayList<Schedule>) -> Unit) {
            var list = ArrayList<Schedule>()
            list.add(schedule)
            callback(list)
        }
    }
}