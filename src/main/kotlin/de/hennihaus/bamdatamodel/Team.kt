package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Team(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    val username: String,
    val password: String,
    val jmsQueue: String,
    val students: List<Student>,
    val statistics: Map<String, Long>,
    val hasPassed: Boolean,
)
