package de.hennihaus.bamdatamodel

import com.fasterxml.jackson.module.kotlin.readValue
import de.hennihaus.bamdatamodel.objectmothers.StatisticObjectMother
import de.hennihaus.bamdatamodel.testutils.bamObjectMapper
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StatisticTest {

    @Test
    fun `should deserialize correctly json into statistic`() {
        val json = getResourceAsText(path = "/statistic.json")

        val result: Statistic = bamObjectMapper().readValue(content = json)

        result shouldBe StatisticObjectMother.getFirstTeamAsyncBankStatistic()
    }

    @Test
    fun `should deserialize correctly a statistic into json`() {
        val statistic = StatisticObjectMother.getFirstTeamAsyncBankStatistic()

        val result: String = bamObjectMapper().writeValueAsString(statistic)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/statistic.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
