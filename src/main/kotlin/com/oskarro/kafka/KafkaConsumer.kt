package com.oskarro.kafka

import com.oskarro.kafka.KafkaConstants.Companion.GROUP_ID
import com.oskarro.kafka.KafkaConstants.Companion.TOPIC_NAME
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class KafkaConsumer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(topics = [TOPIC_NAME], groupId = GROUP_ID)
    fun firstListener(message: String) {
        logger.info("Message received: [$message]")
    }
}