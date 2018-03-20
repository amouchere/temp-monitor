package com.amouchere.temperaturemonitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TemperatureMonitorApplication

fun main(args: Array<String>) {
    runApplication<TemperatureMonitorApplication>(*args)
}
