package xyz.ragunath.nope

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

internal fun getTestFunctions(
  testClass: KClass<*>
): List<NopeTestFunction> {
  return testClass
    .members
    .filter { it.findAnnotation<Nope>() != null }
    .map { callable -> NopeTestFunction(callable.name, callable) }
}

internal fun validate(
  testFunctions: List<NopeTestFunction>
): List<InvalidTest> {
  return testFunctions
    .map(::getSignature)
    .map(::InvalidTest)
}

private fun getSignature(testFunction: NopeTestFunction): String {
  val callable = testFunction.callable!!
  val functionName = callable.name
  val parametersList = callable.parameters.drop(1).map { it.type }
    .joinToString(", ", prefix = "(", postfix = ")")
  return "$functionName$parametersList"
}
