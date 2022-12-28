package de.hennihaus.bamdatamodel

import com.fasterxml.jackson.module.kotlin.readValue
import de.hennihaus.bamdatamodel.objectmothers.PaginationObjectMother.getTeamPaginationWithNoEmptyFields
import de.hennihaus.bamdatamodel.testutils.bamObjectMapper
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PaginationTest {

    @Test
    fun `should deserialize correctly json into team pagination`() {
        val json = getResourceAsText(path = "/pagination.json")

        val result: Pagination<Team> = bamObjectMapper().readValue(content = json)

        result shouldBe getTeamPaginationWithNoEmptyFields()
    }

    @Test
    fun `should serialize correctly a pagination into json`() {
        val pagination = getTeamPaginationWithNoEmptyFields()

        val result: String = bamObjectMapper().writeValueAsString(pagination)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/pagination.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            }
        )
    }
}
