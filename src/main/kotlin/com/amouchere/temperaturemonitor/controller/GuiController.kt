package com.amouchere.temperaturemonitor.controller

import com.amouchere.temperaturemonitor.service.TempService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

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

//        val map: MutableMap<String, String> = HashMap()
//        service.getTemp().forEach {
//            map.put(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(it.date), it.temp.toString())
//        }

        model.addAttribute("temps", service.getTemp());
        // model.addAttribute("temps", service.getTemp().stream().map({ e -> e.temp }).collect(Collectors.toList()));
        // model.addAttribute("date", service.getTemp().stream().map({ e -> e.date }).collect(Collectors.toList()));


        return "temp"
    }
}