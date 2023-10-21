package com.oskarro.service

import com.oskarro.model.Artist
import com.oskarro.model.ArtistDto
import com.oskarro.model.Track
import com.oskarro.repository.ArtistRepository
import com.oskarro.repository.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArtistService(
    val artistRepository: ArtistRepository
) {

    fun getArtists(): Iterable<ArtistDto> = artistRepository.findAll().map { ArtistDto(it) }

    fun addArtist(dto: ArtistDto): ArtistDto {
        return ArtistDto(
            artistRepository.save(
                Artist(
                    id = 0,
                    name = dto.name
                )
            )
        )
    }

    fun updateArtist(dto: ArtistDto): ArtistDto {
        val artist: Artist = artistRepository.findById(dto.id).get()
        artist.name = dto.name
        return ArtistDto(artistRepository.save(artist))
    }

    fun deleteArtist(artistId: Int) {
        artistRepository.deleteById(artistId)
    }
}