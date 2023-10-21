package com.oskarro.controller

import com.oskarro.model.ArtistDto
import com.oskarro.model.Item
import com.oskarro.service.FileProcessorService
import com.oskarro.service.ItemService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/item"])
class ItemController(
    val itemService: ItemService,
    val fileProcessorService: FileProcessorService
) {

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getItems(): Iterable<Item> = itemService.getItems()

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun saveItem(@RequestBody item: Item): Item {
        println("Saving item: $item")
        return itemService.addItem(item)
    }

    @PutMapping(
        value = ["/all"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun saveItems(@RequestBody items: List<Item>) {
        println("Saving items: $items")
        return itemService.addItems(items)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTrack(@PathVariable id: Int) {
        println("Removing item with id: $id")
        itemService.deleteItem(id)
    }

    @DeleteMapping(
        value = ["/all"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteAllTrack() {
        println("Removing all items")
        itemService.deleteAll()
    }

    @PutMapping(
        value = ["/load"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun loadFiles(@RequestBody path: String) {
        println("Loading files from following path: $path")
        fileProcessorService.loadFiles(path)
    }
}