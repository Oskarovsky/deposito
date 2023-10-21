package com.oskarro.model

import java.util.Date

data class TrackDto(
    var title: String?,
    var version: String?,
    var length: Int?,
    var genre: Genre?
) {
    var id: Int = 0
    var created: Date = Date()
    var modified: Date = Date()

    constructor(track: Track): this(
        track.title,
        track.version,
        track.length,
        track.genre
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
        artist.name
    ) {
        id = artist.id
        created = artist.created
        modified = artist.modified
    }
}