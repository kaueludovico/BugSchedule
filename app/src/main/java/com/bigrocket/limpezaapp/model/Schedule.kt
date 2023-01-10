package com.bigrocket.limpezaapp.model

import java.io.Serializable

data class Schedule(
    var typeService: String,
    var date: String,
    var address: Address
) : Serializable
