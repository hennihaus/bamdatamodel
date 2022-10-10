package de.hennihaus.bamdatamodel

import java.util.UUID

data class Student(
    val uuid: UUID,
    val firstname: String,
    val lastname: String,
)
