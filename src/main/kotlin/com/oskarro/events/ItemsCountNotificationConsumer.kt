package com.oskarro.events

import org.springframework.stereotype.Service

@Service
class ItemsCountNotificationConsumer(
    val service: ItemsCountNotificationService
): NotificationConsumer<ItemsCountNotification> {

    override fun accept(e: ItemsCountNotification) {
        e.let {
            service.notify(e)
        }
    }
}