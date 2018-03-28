package com.amouchere.temperaturemonitor.service

import com.amouchere.temperaturemonitor.domain.TempData
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TempService {

    // Some Mocked Values
    private val list = mutableListOf(
            TempData(LocalDateTime.now().minusDays(9), "5.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(8), "6.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(7), "7.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(6), "8.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(5), "9.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(4), "16.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(3), "12.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(2), "12.2".toDouble()),
            TempData(LocalDateTime.now(), "6.4".toDouble())
    )


    fun getTemp(): List<TempData> {
        return list
    }


    fun addTemp(d: TempData): List<TempData> {
        if (list.size > 10) list.removeAt(0)
        list.add(d)
        return list
    }
}