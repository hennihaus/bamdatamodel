package de.hennihaus.bamdatamodel

import de.hennihaus.bamdatamodel.objectmothers.TaskObjectMother
import de.hennihaus.bamdatamodel.testutils.getResourceAsText
import io.kotest.assertions.json.NumberFormat
import io.kotest.assertions.json.compareJsonOptions
import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class TaskTest {

    @Test
    fun `should deserialize correctly json into task`() {
        val json = getResourceAsText(path = "/task.json")

        val result: Task = Json.decodeFromString(string = json)

        result shouldBe TaskObjectMother.getSynchronousBankTask()
    }

    @Test
    fun `should serialize correctly a task into json`() {
        val task = TaskObjectMother.getSynchronousBankTask()

        val result: String = Json.encodeToString(value = task)

        result.shouldEqualJson(
            expected = getResourceAsText(path = "/task.json"),
            options = compareJsonOptions {
                numberFormat = NumberFormat.Strict
            },
        )
    }
}
