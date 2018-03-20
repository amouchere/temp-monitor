package com.amouchere.temperaturemonitor.controller

import com.amouchere.temperaturemonitor.domain.TempData
import com.amouchere.temperaturemonitor.service.TempService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class TempController {

    val logger = LoggerFactory.getLogger(javaClass)!!

    @Autowired
    lateinit var service: TempService

    @GetMapping("/temp")
    fun getTemp(): List<TempData> {
        logger.info("new get request")
        return service.getTemp()
    }


    @PostMapping("/temp")
    fun postTemp(@RequestBody tempData: TempData) {
        logger.info("new post request" + tempData.toString())
        service.addTemp(tempData)
    }


}