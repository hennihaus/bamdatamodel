package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.objectmothers.StatisticObjectMother
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class StatisticTest {

    @Test
    fun `should deserialize correctly json into statistic`() {
        val json = getResourceAsText(path = "/statistic.json")

        val result: Statistic = Json.decodeFromString(string = json)

        result shouldBe StatisticObjectMother.getFirstTeamAsyncBankStatistic()
    }

    @Test
    fun `should deserialize correctly a statistic into json`() {
        val statistic = StatisticObjectMother.getFirstTeamAsyncBankStatistic()

        val result: String = Json.encodeToString(value = statistic)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/statistic.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
