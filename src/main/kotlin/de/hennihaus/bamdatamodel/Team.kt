package de.hennihaus.bamdatamodel

import java.time.LocalDateTime
import java.util.UUID

data class Team(
    val uuid: UUID,
    val type: TeamType,
    val username: String,
    val password: String,
    val jmsQueue: String,
    val students: List<Student>,
    val statistics: Map<String, Long>,
    val hasPassed: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
