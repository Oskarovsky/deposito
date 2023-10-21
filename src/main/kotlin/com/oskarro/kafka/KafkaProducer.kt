package com.oskarro.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class KafkaProducer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendEvent(message: String) {
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message)
    }
}