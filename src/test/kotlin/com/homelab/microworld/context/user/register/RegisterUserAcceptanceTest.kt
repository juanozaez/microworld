package com.homelab.microworld.context.user.register

import com.microworld.user.domain.UserRepository
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort


@SpringBootTest
class RegisterUserAcceptanceTest {

    //@Inject
    //private lateinit var repository: UserRepository

    @Test
    fun `registers an user`() {
        Given {
            body(payload)
        }
        When {
            post("/users")
        } Then {
      //      Assertions.assertEquals(1, repository.findAll().size)
        }

    }

    private val payload = """
        {
          "name": "John",
          "surname": "Doe"
        }
    """.trimIndent()
}
