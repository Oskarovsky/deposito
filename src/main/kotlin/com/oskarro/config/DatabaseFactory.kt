package com.oskarro.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

class DatabaseFactory {

    fun init() {

    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()

        return HikariDataSource(config)
    }
}