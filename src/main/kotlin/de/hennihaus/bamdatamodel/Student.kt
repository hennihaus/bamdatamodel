package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Student(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    val firstname: String,
    val lastname: String,
)
