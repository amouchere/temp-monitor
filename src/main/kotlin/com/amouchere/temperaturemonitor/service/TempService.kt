package com.amouchere.temperaturemonitor.service

import com.amouchere.temperaturemonitor.domain.TempData
import org.springframework.stereotype.Service

@Service
class TempService {

    private val list = mutableListOf<TempData>()

    fun getTemp() = list

    fun addTemp(d: TempData): List<TempData> {
        if (list.size > 10) list.removeAt(0)
        list.add(d)
        return list
    }
}