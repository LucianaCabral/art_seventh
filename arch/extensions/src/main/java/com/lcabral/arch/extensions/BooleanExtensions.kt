package com.lcabral.arch.extensions
private const val TRUE = 1
private const val FALSE = 0

fun Boolean.orFalse() = this ?: false
fun Boolean.orTrue() = this ?: true
fun Boolean.toInt() = if (this) TRUE else FALSE
fun Boolean.toString() : String = if(this) TRUE.toString() else FALSE.toString()

