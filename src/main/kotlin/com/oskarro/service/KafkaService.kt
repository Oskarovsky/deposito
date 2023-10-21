package com.oskarro.service

import com.oskarro.model.NotificationMessage

interface KafkaService {

    fun sendMessage(message: NotificationMessage)
}