package com.amouchere.temperaturemonitor.service

import com.amouchere.temperaturemonitor.domain.TempData
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TempService {

    @Value("\${maxHistory}")
    private var maxHistory: Int? = null
    @Value("\${minRange}")
    private var minRange: Long? = null

    private var lastDate = LocalDate.now().atTime(0, 0)
    private val list = mutableListOf<TempData>()
    val logger = LoggerFactory.getLogger(javaClass)!!

    fun getTemp() = list

    fun addTemp(d: TempData) {

        if (!d.date.isBefore(lastDate.plusMinutes(minRange!!))) {

            // Too many records, just keep the 'maxhistory' last records
            if (list.size > this!!.maxHistory!!) {
                list.removeAt(0)
            }

            list.add(d)

            lastDate = d.date
        } else {
            logger.info("Too recent record" + d.toString())
        }

    }
}