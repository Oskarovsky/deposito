package com.oskarro.controller

import com.oskarro.model.Track
import com.oskarro.model.TrackDto
import com.oskarro.service.TrackService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/track"])
class TrackController(
    val trackService: TrackService
) {

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTracks(): Iterable<TrackDto> = trackService.getTracks()

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun saveTrack(@RequestBody track: Track): Track {
        println("Saving track: $track")
        return trackService.addTrack(track)
    }

    @PostMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTrack(@RequestBody track: Track): Track {
        println("Updating track: $track")
        track.title += " [ updated ]"
        return trackService.updateTrack(track)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTrack(@PathVariable id: Int) {
        println("Removing: $id")
        trackService.deleteTrack(id)
    }


}