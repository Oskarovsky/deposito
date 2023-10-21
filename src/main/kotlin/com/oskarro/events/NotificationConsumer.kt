package com.oskarro.events

import java.util.function.Consumer


interface NotificationConsumer<T>: Consumer<T> {
}