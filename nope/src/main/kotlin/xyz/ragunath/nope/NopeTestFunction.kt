package xyz.ragunath.nope

import kotlin.reflect.KCallable

data class NopeTestFunction(
  val name: String,
  val callable: KCallable<*>? = null
)
