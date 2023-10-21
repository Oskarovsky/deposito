package com.oskarro.service

import com.oskarro.model.Artist
import com.oskarro.model.Track
import com.oskarro.repository.ArtistRepository
import com.oskarro.repository.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArtistService(
    val artistRepository: ArtistRepository
) {

    fun getTracks(): Iterable<Artist> = artistRepository.findAll()

    fun addTrack(artist: Artist): Artist {
        return artistRepository.save(artist)
    }

    fun updateTrack(artist: Artist): Artist {
        return artistRepository.save(artist)
    }

    fun deleteTrack(artistId: Int) {
        artistRepository.deleteById(artistId)
    }
}