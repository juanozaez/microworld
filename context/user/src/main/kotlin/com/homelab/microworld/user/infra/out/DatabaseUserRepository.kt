package com.homelab.microworld.user.infra.out

import com.homelab.microworld.user.domain.Name
import com.homelab.microworld.user.domain.Surname
import com.homelab.microworld.user.domain.User
import com.homelab.microworld.user.domain.UserId
import com.homelab.microworld.user.domain.UserRepository
import jakarta.inject.Named

@Named
class DatabaseUserRepository(private val repository: JpaUserRepository) : UserRepository {

    override fun save(user: User) {
        repository.save(user.toJpa())
    }

    override fun findAll(): List<User> = repository.findAll().map { it.toUser() }
}

fun User.toJpa() = JpaUser(id.toString(), name.toString(), surname.toString())
fun JpaUser.toUser() = User(UserId(id), Name(name), Surname(surname))