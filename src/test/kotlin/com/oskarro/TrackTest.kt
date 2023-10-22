package com.oskarro

import com.oskarro.model.Genre
import com.oskarro.model.TrackDto
import com.oskarro.service.TrackService
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [DepositoApplication::class])
class TrackTest {

    @Autowired
    private lateinit var service: TrackService

    private val tracks = mutableListOf<TrackDto>()

    @BeforeEach
    fun prepare(): Unit {
        println("Preparing tests...")
        assertNotNull(service)
        (0..10).mapTo(tracks) {
            TrackDto(
                title = "Test title $it",
                version = "New version $it",
                length = 3014,
                tempo = 33.10,
                size = 10.0,
                genre = Genre.CLUB
            )
        }
    }

    @Test
    fun insert() {
        tracks.forEach {
            println("Inserting track: $it")
            val result = service.addTrack(it)
            assertNotNull(result)
            assertNotNull(result.id)
            it.id = result.id
        }
    }

    @Test
    fun update() {

    }

    @Test
    fun select() {
        val result = service.getTracks()
        result.forEach {
            assertNotNull(it)
            assertNotNull(it.id)
        }
    }

    @Test
    fun delete() {

    }

    @Test
    @AfterEach
    fun clean() {
        service.getTracks().forEach {
            println("Removing track: $it")
            service.deleteTrack(it.id)
        }
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup(): Unit {
            println("Setup tests...")

        }

        @JvmStatic
        @AfterAll
        fun cleanup(): Unit {

        }
    }

}