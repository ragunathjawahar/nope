package xyz.ragunath.nope

sealed class TestResult {
  data class Passed(
    val name: String
  ) : TestResult()

  data class Failed(
    val name: String,
    val message: String
  ) : TestResult()
}
