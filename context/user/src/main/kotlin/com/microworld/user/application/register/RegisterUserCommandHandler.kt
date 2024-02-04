package com.microworld.user.application.register

import com.microworld.user.domain.Name
import com.microworld.user.domain.Surname
import com.microworld.user.domain.User
import com.microworld.user.domain.UserId
import com.microworld.user.domain.UserRepository
import jakarta.inject.Named
import java.util.UUID

@Named
class CreateUserCommandHandler(private val userRepository: UserRepository) {

    fun handle(command: RegisterUserCommand) {
        userRepository.save(User(UserId(UUID.randomUUID().toString()), Name(command.name), Surname(command.surname)))
    }
}

data class RegisterUserCommand(val name: String, val surname: String)