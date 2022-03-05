package com.pdpano.ainu.configurations

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.ZonedDateTime

@Configuration
class GSONConfiguration {

    @Bean
    fun registerTypes() {
        GsonBuilder().registerTypeAdapter(LocalDateTime::class.java,
            JsonDeserializer { json, type, jsonDeserializationContext ->
                ZonedDateTime.parse(json.asJsonPrimitive.asString).toLocalDateTime()
            }).create()
    }
}