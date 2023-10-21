package com.oskarro

import com.oskarro.config.DatabaseFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication()
class DepositoApplication

fun main(args: Array<String>) {
    runApplication<DepositoApplication>(*args)

    DatabaseFactory().init()

    println("Hello World!")
}