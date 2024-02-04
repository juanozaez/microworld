package com.homelab.microworld.user

import com.homelab.microworld.user.application.register.RegisterUserCommandHandler
import com.homelab.microworld.user.infra.`in`.register.RegisterUserBody
import com.homelab.microworld.user.infra.`in`.register.RegisterUserController
import com.homelab.microworld.user.infra.out.FakeUserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserTest {

    private val repository = FakeUserRepository()
    private val handler = RegisterUserCommandHandler(repository)
    private val controller = RegisterUserController(handler)

    @Test
    fun `registers an user`() {
        controller.register(RegisterUserBody("John", "Doe"))

        assertEquals(1, repository.findAll().size)
    }
}