package com.homelab.microworld.user.application.register

import com.homelab.microworld.user.domain.Name
import com.homelab.microworld.user.domain.Surname
import com.homelab.microworld.user.domain.User
import com.homelab.microworld.user.domain.UserId
import com.homelab.microworld.user.domain.UserRepository
import jakarta.inject.Named
import java.util.UUID

@Named
class RegisterUserCommandHandler(private val userRepository: UserRepository) {

    fun handle(command: RegisterUserCommand) {
        userRepository.save(User(UserId(UUID.randomUUID().toString()), Name(command.name), Surname(command.surname)))
    }
}

data class RegisterUserCommand(val name: String, val surname: String)