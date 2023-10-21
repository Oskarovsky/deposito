package com.oskarro.controller

import com.oskarro.kafka.KafkaProducer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/notification"])
class NotificationController(
    private val kafkaProducer: KafkaProducer
) {

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendTestMessage(
        @RequestBody message: String
    ) {
        kafkaProducer.sendEvent(message)
    }
}