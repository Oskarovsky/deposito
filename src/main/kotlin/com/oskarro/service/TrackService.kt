package com.oskarro.service

import com.oskarro.model.Track
import com.oskarro.model.TrackDto
import com.oskarro.repository.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TrackService(
    val trackRepository: TrackRepository
) {

    fun getTracks(): Iterable<TrackDto> = trackRepository.findAll().map { TrackDto(it) }

    fun addTrack(dto: TrackDto): TrackDto {
        return TrackDto(
            trackRepository.save(
                Track(
                    id = 0,
                    title = dto.title,
                    version = dto.version,
                    length = dto.length,
                    tempo = dto.tempo,
                    genre = dto.genre,
                    size = dto.size
                )
            )
        )
    }

    fun updateTrack(dto: TrackDto): TrackDto {
        val track: Track = trackRepository.findById(dto.id).get()
        track.title = dto.title
        track.version = dto.version
        track.genre = dto.genre
        track.length = dto.length
        track.tempo = dto.tempo
        track.size = dto.size
        return TrackDto(trackRepository.save(track))
    }

    fun deleteTrack(trackId: Int) {
        trackRepository.deleteById(trackId)
    }
}