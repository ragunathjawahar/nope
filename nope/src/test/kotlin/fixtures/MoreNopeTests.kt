package fixtures

import xyz.ragunath.nope.Nope

@Suppress("unused")
class MoreNopeTests {
  @Nope
  fun test1() {
    // no-op
  }

  @Nope
  fun test2() {
    // no-op
  }

  @Nope
  fun test3() {
    // no-op
  }

  private fun notTestFunction() {
    // no-op
  }
}
