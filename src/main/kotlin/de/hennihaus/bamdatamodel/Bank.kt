package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.serializers.URISerializer
import de.hennihaus.bamdatamodel.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.net.URI
import java.util.UUID

@Serializable
data class Bank(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    val name: String,
    val jmsQueue: String,
    @Serializable(with = URISerializer::class)
    val thumbnailUrl: URI,
    val isAsync: Boolean,
    val isActive: Boolean,
    val creditConfiguration: CreditConfiguration?,
    val teams: List<Team>,
)
