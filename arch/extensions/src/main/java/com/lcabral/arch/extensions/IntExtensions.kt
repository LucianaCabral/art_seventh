package com.lcabral.arch.extensions

fun Int?.defaultValue(defaultInt: Int = 0) = this ?: defaultInt

val Int.Companion.ZERO get() = 0

fun Int.isZero() = this == Int.ZERO

