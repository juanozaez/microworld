package com.homelab.microworld.context.user.register

import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RegisterUserAcceptanceTest {

    @LocalServerPort
    private val port = 0

    //@Inject
    //private lateinit var repository: UserRepository

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun greetingShouldReturnDefaultMessage() {
        assertThat(
            restTemplate!!.getForObject(
                "http://localhost:$port/",
                String::class.java
            )
        ).contains("Hello, World")
    }

    @Test
    fun `registers an user`() {
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

        //Given {
         //   body(payload)
        //}
        When {
            post("/")
        } Then {
            statusCode(200)
        } Extract {
            val body = body().asString()
            Assertions.assertEquals(body, "Hello, World")

        }

    }

    private val payload = """
        {
          "name": "John",
          "surname": "Doe"
        }
    """.trimIndent()
}
