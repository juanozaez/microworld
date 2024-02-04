package com.microworld.user.infra.`in`.register

import com.microworld.user.application.register.CreateUserCommandHandler
import com.microworld.user.application.register.RegisterUserCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterUserController(private val commandHandler: CreateUserCommandHandler) {

    @PostMapping("/users")
    fun register(@RequestBody body: RegisterUserBody) {
        commandHandler.handle(RegisterUserCommand(body.name, body.surname))
    }
}

data class RegisterUserBody(val name: String, val surname: String)