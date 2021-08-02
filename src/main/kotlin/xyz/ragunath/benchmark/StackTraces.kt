package xyz.ragunath.benchmark

import com.google.common.truth.Truth.assertThat
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode.Throughput

open class StackTraces {
  @Benchmark
  @BenchmarkMode(Throughput)
  fun init() {
    try {
      failingTest()
    } catch (e: AssertionError) {
      // gulp! swallow 😋
    }
  }

  private fun failingTest() {
    assertThat(false)
      .isTrue()
  }
}
