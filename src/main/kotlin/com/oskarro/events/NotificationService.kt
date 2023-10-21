package com.oskarro.events

interface NotificationService<in T> {

    fun notify(notification: T)
}