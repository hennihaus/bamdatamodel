package de.hennihaus.bamdatamodel.objectmothers

import de.hennihaus.bamdatamodel.Bank
import de.hennihaus.bamdatamodel.CreditConfiguration
import de.hennihaus.bamdatamodel.objectmothers.CreditConfigurationObjectMother.getCreditConfigurationWithNoEmptyFields
import java.net.URI
import java.util.UUID

object BankObjectMother {

    const val SCHUFA_BANK_UUID = "8ab8fef5-1239-42d5-a199-7cb41f68fc21"
    const val SYNC_BANK_UUID = "bf6981d4-0413-4767-8232-c7179b169bc7"
    const val ASYNC_BANK_UUID = "78eefcd4-2459-412e-857f-60f7c5d531c9"

    const val SCHUFA_BANK_NAME = "Schufa"
    const val SYNC_BANK_NAME = "Deutsche Bank"
    const val ASYNC_BANK_NAME = "Sparkasse"

    const val SCHUFA_BANK_JMS_QUEUE = "schufa"
    const val SYNC_BANK_JMS_QUEUE = "deutschebank"
    const val ASYNC_BANK_JMS_QUEUE = "sparkasse"

    const val DEFAULT_THUMBNAIL_URL = "http://0.0.0.0:8085/picture.jpg"
    const val DEFAULT_IS_ACTIVE = true
    const val DEFAULT_TEAMS_COUNT = 3L

    fun getSchufaBank(
        uuid: UUID = UUID.fromString(SCHUFA_BANK_UUID),
        name: String = SCHUFA_BANK_NAME,
        jmsQueue: String = SCHUFA_BANK_JMS_QUEUE,
        thumbnailUrl: URI = URI(DEFAULT_THUMBNAIL_URL),
        isAsync: Boolean = false,
        isActive: Boolean = DEFAULT_IS_ACTIVE,
        creditConfiguration: CreditConfiguration? = null,
        teamsCount: Long = DEFAULT_TEAMS_COUNT,
    ) = Bank(
        uuid = uuid,
        jmsQueue = jmsQueue,
        name = name,
        thumbnailUrl = thumbnailUrl,
        isAsync = isAsync,
        isActive = isActive,
        creditConfiguration = creditConfiguration,
        teamsCount = teamsCount,
    )

    fun getSyncBank(
        uuid: UUID = UUID.fromString(SYNC_BANK_UUID),
        name: String = SYNC_BANK_NAME,
        jmsQueue: String = SYNC_BANK_JMS_QUEUE,
        thumbnailUrl: URI = URI(DEFAULT_THUMBNAIL_URL),
        isAsync: Boolean = false,
        isActive: Boolean = DEFAULT_IS_ACTIVE,
        creditConfiguration: CreditConfiguration? = getCreditConfigurationWithNoEmptyFields(),
        teamsCount: Long = DEFAULT_TEAMS_COUNT,
    ) = Bank(
        uuid = uuid,
        jmsQueue = jmsQueue,
        name = name,
        thumbnailUrl = thumbnailUrl,
        isAsync = isAsync,
        isActive = isActive,
        creditConfiguration = creditConfiguration,
        teamsCount = teamsCount,
    )

    fun getAsyncBank(
        uuid: UUID = UUID.fromString(ASYNC_BANK_UUID),
        name: String = ASYNC_BANK_NAME,
        jmsQueue: String = ASYNC_BANK_JMS_QUEUE,
        thumbnailUrl: URI = URI(DEFAULT_THUMBNAIL_URL),
        isAsync: Boolean = true,
        isActive: Boolean = DEFAULT_IS_ACTIVE,
        creditConfiguration: CreditConfiguration? = getCreditConfigurationWithNoEmptyFields(),
        teamsCount: Long = DEFAULT_TEAMS_COUNT,
    ) = Bank(
        uuid = uuid,
        jmsQueue = jmsQueue,
        name = name,
        thumbnailUrl = thumbnailUrl,
        isAsync = isAsync,
        isActive = isActive,
        creditConfiguration = creditConfiguration,
        teamsCount = teamsCount,
    )
}
