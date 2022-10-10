package de.hennihaus.bamdatamodel

import java.net.URI
import java.util.UUID

data class Bank(
    val uuid: UUID,
    val name: String,
    val jmsQueue: String,
    val thumbnailUrl: URI,
    val isAsync: Boolean,
    val isActive: Boolean,
    val creditConfiguration: CreditConfiguration?,
    val teams: List<Team>,
)
