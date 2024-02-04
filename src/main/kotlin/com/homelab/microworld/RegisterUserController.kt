package com.homelab.microworld

import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class RegisterUserController() {

    @PostConstruct
    fun hola() {
        println("Hola")
    }


    @GetMapping("/users")
    fun register() = "hola"

    @RequestMapping("/")
    @ResponseBody
    fun greeting(): String {
        return "Hello, World"
    }
}
