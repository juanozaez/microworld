package com.homelab.microworld.user.infra.`in`.register

import com.homelab.microworld.user.application.register.RegisterUserCommandHandler
import com.homelab.microworld.user.application.register.RegisterUserCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterUserController(private val commandHandler: RegisterUserCommandHandler) {

    @PostMapping("/users")
    fun register(@RequestBody body: RegisterUserBody) {
        commandHandler.handle(RegisterUserCommand("body.name", "body.surname"))
    }
}

data class RegisterUserBody(val name: String, val surname: String)
