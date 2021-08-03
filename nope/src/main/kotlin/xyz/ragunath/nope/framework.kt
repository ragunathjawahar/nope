package xyz.ragunath.nope

import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.findAnnotation

private const val COMMA = ", "
private const val LPAR = "("
private const val RPAR = ")"

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
  val parametersList = getParameters(callable.parameters)
  return "$functionName$parametersList"
}

private fun getParameters(
  parameters: List<KParameter>
): String {
  return parameters
    .drop(1)
    .map { it.type }
    .joinToString(COMMA, prefix = LPAR, postfix = RPAR)
}
