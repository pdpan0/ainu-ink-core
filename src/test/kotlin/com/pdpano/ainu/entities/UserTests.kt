package com.pdpano.ainu.entities

import com.google.gson.Gson
import com.pdpano.ainu.services.UserService
import org.slf4j.Logger
import com.pdpano.ainu.utils.LogUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDate

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {
    @Autowired
    private lateinit var mockMvc: MockMvc
    @Autowired
    private lateinit var service: UserService

    private val log: Logger = LogUtils().getLogger(javaClass)

    val user = User(0L, "Lucas", LocalDate.of(2001, 2, 16), "lucas@ainu.com.br", "1233211233")

    @BeforeEach
    fun init() {
        log.info("--- Antes ---")
        service.createUser(user)
    }

    @AfterEach
    fun destroy() {
        log.info("--- Depois ---")
    }

//    @Test
//    fun `test criando usuario`() {
//        val newUser = User(0L, "Lucas", LocalDate.of(2001, 2, 16), "lucas-test@ainu.com.br", "1233211233X")
//        val json = Gson().toJson(newUser)
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post("/v1/users").accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON).content(json).header("Authentication", "Basic YWludS5tYXJ0aW5zOnRlc3RlMTIz")
//        ).andExpect(MockMvcResultMatchers.status().isOk).andDo(MockMvcResultHandlers.print())
//
//        Assertions.assertNotNull(service.getUserByEmail(newUser.email))
//    }
}