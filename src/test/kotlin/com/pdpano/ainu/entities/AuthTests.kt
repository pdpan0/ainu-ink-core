package com.pdpano.ainu.entities

import com.google.gson.Gson
import com.pdpano.ainu.services.UserService
import org.slf4j.Logger
import com.pdpano.ainu.utils.LogUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class AuthTests {

    @Autowired
    private lateinit var mockMvc: MockMvc
    @Autowired
    private lateinit var service: UserService

    private val log: Logger = LogUtils().getLogger(javaClass)

    @BeforeEach
    fun init() {
        log.info("--- Antes ---")
    }

    @AfterEach
    fun destroy() {
        log.info("--- Depois ---")
    }

    @Test
    fun `test authenticate user`() {

    }
}