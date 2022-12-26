package de.hennihaus.bamdatamodel

import com.fasterxml.jackson.module.kotlin.readValue
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother
import de.hennihaus.bamdatamodel.testutils.bamObjectMapper
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

        val result: Bank = bamObjectMapper().readValue(content = json)

        result shouldBe BankObjectMother.getSyncBank()
    }

    @Test
    fun `should serialize correctly a bank into json`() {
        val bank = BankObjectMother.getSyncBank()

        val result: String = bamObjectMapper().writeValueAsString(bank)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/bank.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
