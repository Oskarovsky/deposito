package com.oskarro.service

import com.mpatric.mp3agic.ID3v1
import com.mpatric.mp3agic.ID3v2
import com.mpatric.mp3agic.Mp3File
import com.oskarro.model.Genre
import com.oskarro.model.TrackDto
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.name


@Service
class FileProcessorService {

//    https://github.com/mpatric/mp3agic

    fun loadFiles(path: String) {
        Files.walk(Paths.get(path)).use { paths ->
            paths
                .filter { Files.isRegularFile(it) }
                .filter { it.name.endsWith(".mp3") }
                .forEach {
                    val trackDto: TrackDto = convertFileInformation(Mp3File(it))
                    println(trackDto)
                }
        }
    }

    private fun convertFileInformation(file: Mp3File): TrackDto {
        val trackDto: TrackDto
        when {
            file.hasId3v1Tag() -> {
                val tag: ID3v1 = file.id3v1Tag
                trackDto = TrackDto(
                    title = tag.title,
                    version = tag.version,
                    genre = Genre.CLUB,
                    length = file.length.toInt(),
                    size = 0.0,
                    tempo = 0.0
                )
            }
            file.hasId3v2Tag() -> {
                val tag: ID3v2 = file.id3v2Tag
                trackDto = TrackDto(
                    title = tag.title,
                    version = tag.version,
                    genre = Genre.CLUB,
                    length = file.length.toInt(),
                    size = 10.0,
                    tempo = 10.0
                )
            }
            else -> {
                trackDto = TrackDto(
                    title = "",
                    version = "",
                    genre = Genre.CLUB,
                    length = 60,
                    size = 60.0,
                    tempo = 60.0
                )
            }
        }
        return trackDto
    }
}