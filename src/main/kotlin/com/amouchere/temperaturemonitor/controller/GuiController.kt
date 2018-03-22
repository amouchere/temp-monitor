package com.amouchere.temperaturemonitor.controller

import com.amouchere.temperaturemonitor.service.TempService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@Controller
class GuiController {

    @Autowired
    lateinit var service: TempService


    @RequestMapping("/")
    fun index(): String {
        return "index"
    }


    @RequestMapping("/gui")
    fun findStudent(model: Model): String {

        val map: HashMap<Long, Double> = HashMap()

        service.getTemp().forEach {
            map[it.date] = it.temp
        }

        model.addAttribute("temps", map.toSortedMap())
        return "temp"
    }
}