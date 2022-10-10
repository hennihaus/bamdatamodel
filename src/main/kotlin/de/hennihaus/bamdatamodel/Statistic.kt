package de.hennihaus.bamdatamodel

import java.util.UUID

data class Statistic(
    val bankId: UUID,
    val teamId: UUID,
    val requestsCount: Long?,
)
