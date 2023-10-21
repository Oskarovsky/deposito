package com.oskarro.model

import java.util.Date

data class TrackDto(
    var title: String?,
    var version: String?,
    var length: Int?,
    var tempo: Double?,
    var size: Double?,
    var genre: Genre?
) {
    var id: Int = 0
    var created: Date = Date()
    var modified: Date = Date()

    constructor(track: Track): this(
        title = track.title,
        version = track.version,
        length = track.length,
        tempo = track.tempo,
        size = track.size,
        genre = track.genre
    ) {
        id = track.id
        created = track.created
        modified = track.modified
    }
}

data class ArtistDto(
    var name: String,
) {
    var id: Int = 0
    var created: Date = Date()
    var modified: Date = Date()

    constructor(artist: Artist): this(
        name = artist.name
    ) {
        id = artist.id
        created = artist.created
        modified = artist.modified
    }
}