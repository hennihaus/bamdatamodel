package de.hennihaus.bamdatamodel

data class Pagination<Item : Any>(
    val first: String,
    val prev: String?,
    val next: String?,
    val last: String,
    val items: List<Item>,
)
