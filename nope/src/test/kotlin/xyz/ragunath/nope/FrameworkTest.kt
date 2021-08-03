package xyz.ragunath.nope

import com.google.common.truth.Truth.assertThat
import fixtures.Foo
import fixtures.InvalidTestsTakingInParameters
import fixtures.MoreNopeTests
import fixtures.NopeCanaryTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FrameworkTest {
  @Nested
  inner class GetTestFunctions {
    @Test
    fun `return empty list if it is not a test class`() {
      // given & when
      val functions = getTestFunctions(Foo::class)

      // then
      assertThat(functions)
        .isEmpty()
    }

    @Test
    fun `return a list of functions from a test class (annotated with @Nope)`() {
      // given & when
      val functions = getTestFunctions(NopeCanaryTest::class)

      // then
      assertThat(functions)
        .hasSize(1)
      assertThat(functions.first().name)
        .isEqualTo("nope is setup")
    }

    @Test
    fun `return only test functions and ignore the rest`() {
      // given & when
      val functions = getTestFunctions(MoreNopeTests::class)

      // then
      assertThat(functions.map { it.name })
        .containsExactly(
          "test1",
          "test2",
          "test3",
        )
    }
  }

  @Nested
  inner class Validation {
    @Test
    fun `test functions with parameters are invalid`() {
      // given & when
      val validatedTests = validate(getTestFunctions(InvalidTestsTakingInParameters::class))

      // then
      assertThat(validatedTests)
        .containsExactly(
          InvalidTest("test1(kotlin.String)"),
          InvalidTest("test2(kotlin.Int, kotlin.Int)"),
        )
    }
  }
}
