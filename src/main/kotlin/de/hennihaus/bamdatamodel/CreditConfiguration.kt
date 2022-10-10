package de.hennihaus.bamdatamodel

data class CreditConfiguration(
    val minAmountInEuros: Int,
    val maxAmountInEuros: Int,
    val minTermInMonths: Int,
    val maxTermInMonths: Int,
    val minSchufaRating: RatingLevel,
    val maxSchufaRating: RatingLevel,
)
