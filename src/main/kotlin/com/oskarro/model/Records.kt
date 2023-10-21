package com.oskarro.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import kotlin.collections.HashSet

@Entity(name = "Artist")
@Table(name = "artist")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnoreProperties("tracks")
    var tracks: Set<Track> = HashSet(),

    @CreationTimestamp
    var created: Date = Date(),

    @UpdateTimestamp
    var modified: Date = Date()

)

@Entity
@Table(name = "track")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Track(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var title: String?,

    var version: String?,

    var length: Int?,

    var tempo: Double?,

    var size: Double?,

    @ManyToMany(mappedBy = "tracks", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tracks")
    var artists: Set<Artist> = HashSet(),

    var genre: Genre?,

    @CreationTimestamp
    var created: Date = Date(),

    @UpdateTimestamp
    var modified: Date = Date()

)

enum class Genre {
    CLUB, TECHNO, DISCO, COMMERCIAL
}
