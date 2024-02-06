package com.homelab.microworld.user.infra.out

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface JpaUserRepository : JpaRepository<JpaUser, UUID>