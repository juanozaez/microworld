package com.microworld.user.infra.out

import com.microworld.user.domain.User
import com.microworld.user.domain.UserRepository
import jakarta.inject.Named

@Named
class FakeUserRepository : UserRepository {
    private val users = mutableListOf<User>()

    override fun save(user: User) {
        println("User $user added")
        users.add(user)
    }

    override fun findAll(): List<User> = users
}