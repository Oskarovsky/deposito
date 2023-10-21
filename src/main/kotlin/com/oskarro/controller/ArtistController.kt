package com.oskarro.controller

import com.oskarro.model.ArtistDto
import com.oskarro.service.ArtistService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/artist"])
class ArtistController(
    val artistService: ArtistService
) {

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getArtists(): Iterable<ArtistDto> = artistService.getArtists()

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun saveArtist(@RequestBody artist: ArtistDto): ArtistDto {
        println("Saving artist: $artist")
        return artistService.addArtist(artist)
    }

    @PostMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateArtist(@RequestBody artist: ArtistDto): ArtistDto {
        println("Updating artist: $artist")
        artist.name += " [ updated ]"
        return artistService.updateArtist(artist)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteArtist(@PathVariable id: Int) {
        println("Removing artist with id: $id")
        artistService.deleteArtist(id)
    }
}