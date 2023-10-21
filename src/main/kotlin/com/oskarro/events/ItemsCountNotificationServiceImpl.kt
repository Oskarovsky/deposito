package com.oskarro.events

import com.oskarro.model.NotificationMessage
import com.oskarro.service.KafkaService
import org.springframework.stereotype.Service

@Service
class ItemsCountNotificationServiceImpl(
    private val kafkaService: KafkaService
): ItemsCountNotificationService {

    override fun notify(notification: ItemsCountNotification) {
        val text = "New records has been processed: ${notification.itemsCount}"
        kafkaService.sendMessage(NotificationMessage(text))
    }
}