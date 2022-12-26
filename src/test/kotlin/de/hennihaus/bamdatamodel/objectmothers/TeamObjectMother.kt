package de.hennihaus.bamdatamodel.objectmothers

import de.hennihaus.bamdatamodel.Student
import de.hennihaus.bamdatamodel.Team
import de.hennihaus.bamdatamodel.TeamType
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother.ASYNC_BANK_NAME
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother.SCHUFA_BANK_NAME
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother.SYNC_BANK_NAME
import de.hennihaus.bamdatamodel.objectmothers.DateTimeObjectMother.DEFAULT_LOCAL_DATE_TIME
import de.hennihaus.bamdatamodel.objectmothers.StudentObjectMother.getFirstStudent
import de.hennihaus.bamdatamodel.objectmothers.StudentObjectMother.getSecondStudent
import de.hennihaus.bamdatamodel.objectmothers.StudentObjectMother.getThirdStudent
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID

object TeamObjectMother {

    const val FIRST_TEAM_UUID = "63701a57-91b8-40d4-b4e2-b8dd9e7a75a5"
    const val SECOND_TEAM_UUID = "c4a2dd22-f3d4-4de2-9fe0-dbe70062bef9"
    const val THIRD_TEAM_UUID = "40226a72-b520-4f84-b806-b3ab30ff1769"
    const val EXAMPLE_TEAM_UUID = "9426de16-95b9-4250-b22f-6d1d6d9b8d7e"

    const val FIRST_TEAM_USERNAME = "Team01"
    const val SECOND_TEAM_USERNAME = "Team02"
    const val THIRD_TEAM_USERNAME = "Team03"
    const val EXAMPLE_TEAM_USERNAME = "Beispielteam"

    const val EXAMPLE_TEAM_PASSWORD = "OOfKqWksmA"

    const val FIRST_TEAM_JMS_QUEUE = "ResponseQueueTeam01"
    const val SECOND_TEAM_JMS_QUEUE = "ResponseQueueTeam02"
    const val THIRD_TEAM_JMS_QUEUE = "ResponseQueueTeam03"
    const val EXAMPLE_TEAM_JMS_QUEUE = "ResponseQueueBeispielteam"

    const val DEFAULT_PASSWORD = "lkhNqstcxs"
    const val DEFAULT_HAS_PASSED = false

    fun getFirstTeam(
        uuid: UUID = UUID.fromString(FIRST_TEAM_UUID),
        type: TeamType = TeamType.REGULAR,
        username: String = FIRST_TEAM_USERNAME,
        password: String = DEFAULT_PASSWORD,
        jmsQueue: String = FIRST_TEAM_JMS_QUEUE,
        students: List<Student> = getDefaultStudents(),
        statistics: Map<String, Long> = getZeroStatistics(),
        hasPassed: Boolean = DEFAULT_HAS_PASSED,
        createdAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
        updatedAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
    ) = Team(
        uuid = uuid,
        type = type,
        username = username,
        password = password,
        jmsQueue = jmsQueue,
        students = students,
        statistics = statistics,
        hasPassed = hasPassed,
        createdAt = createdAt.truncatedTo(ChronoUnit.SECONDS),
        updatedAt = updatedAt.truncatedTo(ChronoUnit.SECONDS),
    )

    fun getSecondTeam(
        uuid: UUID = UUID.fromString(SECOND_TEAM_UUID),
        type: TeamType = TeamType.REGULAR,
        username: String = SECOND_TEAM_USERNAME,
        password: String = DEFAULT_PASSWORD,
        jmsQueue: String = SECOND_TEAM_JMS_QUEUE,
        students: List<Student> = getDefaultStudents(),
        statistics: Map<String, Long> = getZeroStatistics(),
        hasPassed: Boolean = DEFAULT_HAS_PASSED,
        createdAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
        updatedAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
    ) = Team(
        uuid = uuid,
        type = type,
        username = username,
        password = password,
        jmsQueue = jmsQueue,
        students = students,
        statistics = statistics,
        hasPassed = hasPassed,
        createdAt = createdAt.truncatedTo(ChronoUnit.SECONDS),
        updatedAt = updatedAt.truncatedTo(ChronoUnit.SECONDS),
    )

    fun getThirdTeam(
        uuid: UUID = UUID.fromString(THIRD_TEAM_UUID),
        type: TeamType = TeamType.REGULAR,
        username: String = THIRD_TEAM_USERNAME,
        password: String = DEFAULT_PASSWORD,
        jmsQueue: String = THIRD_TEAM_JMS_QUEUE,
        students: List<Student> = getDefaultStudents(),
        statistics: Map<String, Long> = getZeroStatistics(),
        hasPassed: Boolean = DEFAULT_HAS_PASSED,
        createdAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
        updatedAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
    ) = Team(
        uuid = uuid,
        type = type,
        username = username,
        password = password,
        jmsQueue = jmsQueue,
        students = students,
        statistics = statistics,
        hasPassed = hasPassed,
        createdAt = createdAt.truncatedTo(ChronoUnit.SECONDS),
        updatedAt = updatedAt.truncatedTo(ChronoUnit.SECONDS),
    )

    fun getExampleTeam(
        uuid: UUID = UUID.fromString(EXAMPLE_TEAM_UUID),
        type: TeamType = TeamType.EXAMPLE,
        username: String = EXAMPLE_TEAM_USERNAME,
        password: String = EXAMPLE_TEAM_PASSWORD,
        jmsQueue: String = EXAMPLE_TEAM_JMS_QUEUE,
        students: List<Student> = getDefaultStudents(),
        statistics: Map<String, Long> = getZeroStatistics(),
        hasPassed: Boolean = DEFAULT_HAS_PASSED,
        createdAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
        updatedAt: LocalDateTime = LocalDateTime.parse(DEFAULT_LOCAL_DATE_TIME),
    ) = Team(
        uuid = uuid,
        type = type,
        username = username,
        password = password,
        jmsQueue = jmsQueue,
        students = students,
        statistics = statistics,
        hasPassed = hasPassed,
        createdAt = createdAt.truncatedTo(ChronoUnit.SECONDS),
        updatedAt = updatedAt.truncatedTo(ChronoUnit.SECONDS),
    )

    fun getZeroStatistics(): Map<String, Long> = mapOf(
        SCHUFA_BANK_NAME to 0L,
        SYNC_BANK_NAME to 0L,
        ASYNC_BANK_NAME to 0L,
    )

    fun getNonZeroStatistics(): Map<String, Long> = mapOf(
        SCHUFA_BANK_NAME to 1L,
        SYNC_BANK_NAME to 1L,
        ASYNC_BANK_NAME to 1L,
    )

    private fun getDefaultStudents(): List<Student> = listOf(
        getFirstStudent(),
        getSecondStudent(),
        getThirdStudent(),
    )
}
