package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Statistic(
    @Serializable(with = UUIDSerializer::class)
    val bankId: UUID,
    @Serializable(with = UUIDSerializer::class)
    val teamId: UUID,
    val requestsCount: Long?,
)
