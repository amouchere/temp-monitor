package com.amouchere.temperaturemonitor.service

import com.amouchere.temperaturemonitor.domain.TempData
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TempService {

    @Value("\${maxHistory}")
    private var maxHistory: Int? = null

    private val list = mutableListOf<TempData>()

    fun getTemp() = list

    fun addTemp(d: TempData): List<TempData> {
        if (list.size > this!!.maxHistory!!) list.removeAt(0)
        list.add(d)
        return list
    }
}