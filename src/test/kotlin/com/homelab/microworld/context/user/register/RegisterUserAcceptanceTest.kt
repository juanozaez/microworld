package com.homelab.microworld.context.user.register

import com.homelab.microworld.shared.AbstractAcceptanceTest
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
