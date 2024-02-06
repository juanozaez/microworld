package com.homelab.microworld.user.infra.out

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users", schema = "users")
data class JpaUser(
    @Id
    val id: String,
    val name: String?,
    val surname: String?
)


