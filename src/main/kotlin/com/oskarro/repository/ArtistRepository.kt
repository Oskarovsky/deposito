package com.oskarro.repository

import com.oskarro.model.Artist
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository: CrudRepository<Artist, Int> { }