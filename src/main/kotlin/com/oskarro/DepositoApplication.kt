package com.oskarro

import com.oskarro.config.DatabaseFactory
import com.oskarro.events.ItemsCountNotificationConsumer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DepositoApplication(
    val itemsCountNotificationConsumer: ItemsCountNotificationConsumer
) {
}

fun main(args: Array<String>) {
    runApplication<DepositoApplication>(*args)

    DatabaseFactory().init()

    println("Deposito application has been started!")
}