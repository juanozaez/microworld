package com.homelab.microworld.user.domain

data class User(val id: UserId, val name: Name, val surname: Surname)

data class UserId(private val value: String) {
    override fun toString() = value
}

data class Name(private val value: String) {
    override fun toString() = value
}

data class Surname(private val value: String) {
    override fun toString() = value
}