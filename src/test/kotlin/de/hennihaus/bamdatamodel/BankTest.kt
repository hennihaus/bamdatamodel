package de.hennihaus.bamdatamodel

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    fun `should deserialize correctly json into bank`() {
        val json = getResourceAsText(path = "/bank.json")

        val result: Bank = jacksonObjectMapper().readValue(content = json)

        result shouldBe BankObjectMother.getSyncBank()
    }

    @Test
    fun `should serialize correctly a bank into json`() {
        val bank = BankObjectMother.getSyncBank()

        val result: String = jacksonObjectMapper().writeValueAsString(bank)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/bank.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
