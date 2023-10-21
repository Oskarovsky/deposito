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

    fun addTrack(track: Track): Track {
        return trackRepository.save(track)
    }

    fun updateTrack(track: Track): Track {
        return trackRepository.save(track)
    }

    fun deleteTrack(trackId: Int) {
        trackRepository.deleteById(trackId)
    }
}