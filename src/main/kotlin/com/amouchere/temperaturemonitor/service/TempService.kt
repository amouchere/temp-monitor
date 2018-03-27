package com.amouchere.temperaturemonitor.service

import com.amouchere.temperaturemonitor.domain.TempData
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TempService {

    private val list = mutableListOf(
            TempData(LocalDateTime.now().minusDays(9).toEpochSecond(ZoneOffset.UTC) * 1000, "5.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(8).toEpochSecond(ZoneOffset.UTC) * 1000, "6.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(7).toEpochSecond(ZoneOffset.UTC) * 1000, "7.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(6).toEpochSecond(ZoneOffset.UTC) * 1000, "8.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(5).toEpochSecond(ZoneOffset.UTC) * 1000, "9.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(4).toEpochSecond(ZoneOffset.UTC) * 1000, "16.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(3).toEpochSecond(ZoneOffset.UTC) * 1000, "12.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(2).toEpochSecond(ZoneOffset.UTC) * 1000, "12.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(2).plusMinutes(4).toEpochSecond(ZoneOffset.UTC) * 1000, "12.2".toDouble()),
            TempData(LocalDateTime.now().minusDays(1).toEpochSecond(ZoneOffset.UTC) * 1000, "10.7".toDouble()),
            TempData(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) * 1000, "6.4".toDouble())
    )


    fun getTemp(): List<TempData> {
        return list
    }


    fun addTemp(d: TempData): List<TempData> {
        list.add(d)
        return list
    }
}