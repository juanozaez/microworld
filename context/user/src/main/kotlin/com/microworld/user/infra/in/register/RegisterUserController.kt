package com.microworld.user.infra.`in`.register

import com.microworld.user.application.register.CreateUserCommandHandler
import com.microworld.user.application.register.RegisterUserCommand
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class RegisterUserController(private val commandHandler: CreateUserCommandHandler) {

    @PostConstruct
    fun hola(){
        println("Hola2")
    }

    @PostMapping("/users")
    fun register(@RequestBody body: RegisterUserBody) {
        commandHandler.handle(RegisterUserCommand(body.name, body.surname))
    }

    @GetMapping("/users")
    fun register() = "hola"

    @RequestMapping("/")
    @ResponseBody
    fun greeting(): String {
        return "Hello, World"
    }
}

data class RegisterUserBody(val name: String, val surname: String)
