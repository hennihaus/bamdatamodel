package de.hennihaus.bamdatamodel.testutils

fun getResourceAsText(path: String): String = object {}.javaClass.getResource(path)!!.readText()
