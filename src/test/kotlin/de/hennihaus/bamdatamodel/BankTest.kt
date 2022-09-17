package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    fun `should deserialize correctly json into bank`() {
        val json = getResourceAsText(path = "/bank.json")

        val result: Bank = Json.decodeFromString(string = json)

        result shouldBe BankObjectMother.getSyncBank()
    }

    @Test
    fun `should serialize correctly a bank into json`() {
        val bank = BankObjectMother.getSyncBank()

        val result: String = Json.encodeToString(value = bank)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/bank.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
