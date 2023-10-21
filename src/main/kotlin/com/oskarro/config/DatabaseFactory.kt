package com.oskarro.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

class DatabaseFactory {

    fun init() {
        println("TESTING connection: ")
        val connection = hikari().getConnection()
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
//        config.dataSource
        config.username = "postgres"
        config.password = "postgres"
        config.jdbcUrl = "jdbc:postgresql://localhost:5435/deposito_db"
        config.driverClassName = "org.postgresql.Driver"
        return HikariDataSource(config)
    }
}