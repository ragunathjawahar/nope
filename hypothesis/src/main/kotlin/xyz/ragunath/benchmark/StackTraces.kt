package xyz.ragunath.benchmark

import com.google.common.truth.Truth.assertThat
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode.Throughput

open class StackTraces {
  @Benchmark
  @BenchmarkMode(Throughput)
  fun stackTraceTest(state: BenchmarkState) {
    try {
      assertThat(state.isTrue)
        .isTrue()
    } catch (e: AssertionError) {
      // gulp! swallow 😋
    }
  }
}
