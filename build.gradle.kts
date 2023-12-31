import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    java
    application
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    kotlin("plugin.jpa") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.flywaydb.flyway") version "8.5.4"
}

apply(plugin = "io.spring.dependency-management")


group = "com.oskarro"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("DepositoApplication")
}

repositories {
    mavenCentral()
}

val kafkaApiVersion = "3.3.1"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.1.5"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.kafka:spring-kafka:3.0.12")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-RC")

    implementation("io.projectreactor:reactor-core:3.5.11")
    implementation("org.apache.kafka:kafka-clients:$kafkaApiVersion")
    implementation("org.apache.kafka:kafka-streams:$kafkaApiVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.3")
    implementation("com.mpatric:mp3agic:0.9.1")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")

    implementation("org.postgresql:postgresql:42.2.27")
    implementation("com.zaxxer:HikariCP:2.7.8")
    implementation("org.flywaydb:flyway-core:9.17.0")
    implementation("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(mapOf("group" to "org.junit.vintage", "module" to "junit-vintage-engine"))
    }
    testImplementation("org.apache.kafka:kafka-streams-test-utils:$kafkaApiVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(kotlin("test"))
}

flyway {
    url = "127.0.0.1:5435"
    user = "postgres"
    password = "postgres"
    baselineOnMigrate = true
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.register<JavaExec>("migrate") {
    group = "Execution"
    description = "Migrates the database to the latest version"
    classpath = sourceSets.getByName("main").runtimeClasspath
    mainClass.set("com.oskarro.migrations.RunMigrations")

    val user = System.getenv("POSTGRES_ADMIN_USER")
        ?: "postgres"
    val pass = System.getenv("POSTGRES_ADMIN_PASSWORD")
        ?: "postgres"
    args = listOf(user, pass)
}