package com.microworld.eventbus

import java.time.ZonedDateTime

data class DomainEvent(private val aggregateId: String, private val occurredOn: ZonedDateTime)
