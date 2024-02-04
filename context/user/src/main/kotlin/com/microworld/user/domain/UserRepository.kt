package com.microworld.user.domain

interface UserRepository {

    fun save(user: User)
    fun findAll(): List<User>
}