package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.objectmothers.TeamObjectMother
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class TeamTest {

    @Test
    fun `should deserialize correctly json into team`() {
        val json = getResourceAsText(path = "/team.json")

        val result: Team = Json.decodeFromString(string = json)

        result shouldBe TeamObjectMother.getFirstTeam()
    }

    @Test
    fun `should serialize correctly a team into json`() {
        val team = TeamObjectMother.getFirstTeam()

        val result: String = Json.encodeToString(value = team)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/team.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
