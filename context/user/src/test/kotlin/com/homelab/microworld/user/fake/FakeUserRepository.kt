package com.homelab.microworld.user.fake

import com.homelab.microworld.user.domain.User
import com.homelab.microworld.user.domain.UserRepository

class FakeUserRepository : UserRepository {
    private val users = mutableListOf<User>()

    override fun save(user: User) {
        users.add(user)
    }

    override fun findAll(): List<User> = users
}