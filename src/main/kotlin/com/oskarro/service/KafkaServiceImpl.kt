package com.oskarro.service

import com.oskarro.kafka.KafkaProducer
import com.oskarro.model.NotificationMessage
import org.springframework.stereotype.Service

@Service
class KafkaServiceImpl(
    private val kafkaProducer: KafkaProducer
): KafkaService {

    override fun sendMessage(message: NotificationMessage) {
        kafkaProducer.sendEvent(message.content)
    }
}