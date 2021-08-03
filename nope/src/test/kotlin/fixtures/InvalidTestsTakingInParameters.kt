package fixtures

import xyz.ragunath.nope.Nope

@Suppress("unused", "UNUSED_PARAMETER")
class InvalidTestsTakingInParameters {
  @Nope
  fun test1(name: String) {
    // no-op
  }

  @Nope
  fun test2(a: Int, b: Int) {
    // no-op
  }
}
