package com.oskarro.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "Artist")
@Table(name = "artist")
data class Artist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var name: String,

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinTable(
        name = "artist_track",
        joinColumns = [JoinColumn(name = "artist_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "track_id", referencedColumnName = "id")])
//    @JsonIgnoreProperties("artists")
    var tracks: Set<Track> = HashSet()
)

@Entity
@Table(name = "track")
data class Track(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var title: String?,

    var version: String?,

    var length: Int?,

    var tempo: Double?,

    var size: Double?,

    @ManyToMany(mappedBy = "tracks")
//    @JsonIgnoreProperties("tracks")
    var artists: Set<Artist> = HashSet(),

    var genre: Genre?
)

enum class Genre {
    CLUB, TECHNO, DISCO, COMMERCIAL
}
