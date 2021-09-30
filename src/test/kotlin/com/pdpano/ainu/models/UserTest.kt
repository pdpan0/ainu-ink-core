package com.pdpano.ainu.models

import org.junit.jupiter.api.Assertions.assertNotNull
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.time.LocalDate

internal class UserTest: Spek({
    describe("User Test") {
        context("Ao criar um usuário") {
            it("Todos os atributos deverão ser mapeados") {
                val user: User = User (
                    1L,
                    "lucas",
                    LocalDate.now(),
                    "lucas.martins@ainu.com.br",
                    "1233211232"
                )

                assertNotNull(user)
            }
        }
    }
})