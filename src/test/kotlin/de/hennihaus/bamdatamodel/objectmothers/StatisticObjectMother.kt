package de.hennihaus.bamdatamodel.objectmothers

import de.hennihaus.bamdatamodel.Statistic
import de.hennihaus.bamdatamodel.objectmothers.BankObjectMother.ASYNC_BANK_UUID
import de.hennihaus.bamdatamodel.objectmothers.TeamObjectMother.FIRST_TEAM_UUID
import java.util.UUID

object StatisticObjectMother {

    const val ZERO_REQUESTS_COUNT = 0L

    fun getFirstTeamAsyncBankStatistic(
        bankId: UUID = UUID.fromString(ASYNC_BANK_UUID),
        teamId: UUID = UUID.fromString(FIRST_TEAM_UUID),
        requestsCount: Long = ZERO_REQUESTS_COUNT,
    ) = Statistic(
        bankId = bankId,
        teamId = teamId,
        requestsCount = requestsCount,
    )
}
