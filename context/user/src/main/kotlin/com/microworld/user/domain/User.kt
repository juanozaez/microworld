package com.microworld.user.domain

data class User(private val id: UserId, private val name: Name, private val surname: Surname)

data class UserId(private val value: String)
data class Name(private val value: String)
data class Surname(private val value: String)