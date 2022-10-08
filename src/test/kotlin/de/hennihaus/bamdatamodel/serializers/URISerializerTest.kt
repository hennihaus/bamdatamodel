package de.hennihaus.bamdatamodel.serializers

import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import java.net.URI

class URISerializerTest {

    @Serializable
    data class TestObject(@Serializable(with = URISerializer::class) val uri: URI)

    @Test
    fun `should deserialize an object with URI property correctly`() {
        val testJson = """{"uri":"http://0.0.0.0:8080"}"""

        val result: TestObject = Json.decodeFromString(string = testJson)

        result shouldBe TestObject(uri = URI("http://0.0.0.0:8080"))
    }

    @Test
    fun `should serialize an object with URI property correctly`() {
        val testObject = TestObject(uri = URI("http://0.0.0.0:8080"))

        val result: String = Json.encodeToString(value = testObject)

        result shouldBe """{"uri":"http://0.0.0.0:8080"}"""
    }
}
