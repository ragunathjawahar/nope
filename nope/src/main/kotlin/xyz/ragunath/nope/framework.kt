package xyz.ragunath.nope

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

internal fun getTestFunctions(
  testClass: KClass<*>
): List<NopeTestFunction> {
  return testClass
    .members
    .filter { it.findAnnotation<Nope>() != null }
    .map { NopeTestFunction(it.name) }
}
