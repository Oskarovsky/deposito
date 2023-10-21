package com.oskarro.controller

import com.oskarro.model.ArtistDto
import com.oskarro.service.ArtistService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping(value = ["/api/v1/artist"])
class ArtistController(
    val artistService: ArtistService
) {

    @GetMapping(path = ["/numbers"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getDemo(): Flux<Int> = Flux.range(1, 100)

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getArtists(): Iterable<ArtistDto> = artistService.getArtists()

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun saveTrack(@RequestBody artist: ArtistDto): ArtistDto {
        println("Saving artist: $artist")
        return artistService.addArtist(artist)
    }

    @PostMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTrack(@RequestBody artist: ArtistDto): ArtistDto {
        println("Updating track: $artist")
        artist.name += " [ updated ]"
        return artistService.updateArtist(artist)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTrack(@PathVariable id: Int) {
        println("Removing: $id")
        artistService.deleteArtist(id)
    }
}