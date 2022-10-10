package de.hennihaus.bamdatamodel

import java.util.UUID

data class Team(
    val uuid: UUID,
    val username: String,
    val password: String,
    val jmsQueue: String,
    val students: List<Student>,
    val statistics: Map<String, Long>,
    val hasPassed: Boolean,
)
