package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.serializers.ContentTypeSerializer
import de.hennihaus.bamdatamodel.serializers.HttpStatusCodeSerializer
import de.hennihaus.bamdatamodel.serializers.UUIDSerializer
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Response(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    @Serializable(with = HttpStatusCodeSerializer::class)
    val httpStatusCode: HttpStatusCode,
    @Serializable(with = ContentTypeSerializer::class)
    val contentType: ContentType,
    val description: String,
    val example: String,
)
