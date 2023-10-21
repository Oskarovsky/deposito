package com.oskarro.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping(value = ["/api/v1/artist"])
class ArtistController {

    @GetMapping(path = ["/numbers"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getArtists(): Flux<Int> = Flux.range(1, 100)
}