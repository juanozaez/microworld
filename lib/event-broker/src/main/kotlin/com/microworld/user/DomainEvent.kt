package com.microworld.user

import java.time.ZonedDateTime

data class DomainEvent(private val aggregateId: String, private val occurredOn: ZonedDateTime)
