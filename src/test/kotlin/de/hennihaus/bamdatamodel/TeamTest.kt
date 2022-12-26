package de.hennihaus.bamdatamodel

import com.fasterxml.jackson.module.kotlin.readValue
import de.hennihaus.bamdatamodel.objectmothers.TeamObjectMother
import de.hennihaus.bamdatamodel.testutils.bamObjectMapper
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class TeamTest {

    @Test
    fun `should deserialize correctly json into team`() {
        val json = getResourceAsText(path = "/team.json")

        val result: Team = bamObjectMapper().readValue(content = json)

        result shouldBe TeamObjectMother.getFirstTeam()
    }

    @Test
    fun `should serialize correctly a team into json`() {
        val team = TeamObjectMother.getFirstTeam()

        val result: String = bamObjectMapper().writeValueAsString(team)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/team.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
