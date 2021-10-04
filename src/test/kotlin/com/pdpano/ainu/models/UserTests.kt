package com.pdpano.ainu.models

import com.fasterxml.jackson.databind.ObjectMapper
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
class UserTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test criando usuario`() {
        val user = User(0L,"Lucas", LocalDate.of(2001,2,16),"lucas@ainu.com.br", "1233211233")
        val json = ObjectMapper().findAndRegisterModules().writeValueAsString(user)

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/users").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}