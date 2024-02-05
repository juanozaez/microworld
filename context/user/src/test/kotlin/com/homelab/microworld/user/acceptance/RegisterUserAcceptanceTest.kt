package com.homelab.microworld.user.acceptance

import com.homelab.microworld.user.AbstractAcceptanceTest
import com.homelab.microworld.user.domain.UserRepository
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RegisterUserAcceptanceTest : AbstractAcceptanceTest() {

    @Inject
    private lateinit var repository: UserRepository

    @Test
    fun `registers an user`() {
        postRequest(payload, "/users")

        assertEquals(1, repository.findAll().size)
    }

    private val payload = """
        {
          "name": "John",
          "surname": "Doe"
        }
    """
}
