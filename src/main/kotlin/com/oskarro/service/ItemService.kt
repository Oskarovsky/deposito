package com.oskarro.service

import com.oskarro.events.ItemsCountNotification
import com.oskarro.events.ItemsCountNotificationService
import com.oskarro.model.Item
import com.oskarro.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    val itemRepository: ItemRepository,
    val notificationService: ItemsCountNotificationService
) {

    fun getItems(): Iterable<Item> = itemRepository.findAll()

    fun addItem(item: Item): Item {
        return itemRepository.save(item)
    }

    fun addItems(items: List<Item>) {
        val results = itemRepository.saveAll(items)
        val notification = ItemsCountNotification(results.count())
        notificationService.notify(notification)
    }

    fun deleteItem(id: Int) {
        itemRepository.deleteById(id)
    }

    fun deleteAll() {
        itemRepository.deleteAll()
    }
}