package com.oskarro.repository

import com.oskarro.model.Track
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TrackRepository: CrudRepository<Track, Int> { }