package xyz.ragunath.benchmark

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode.Throughput
import xyz.ragunath.nope.TestResult
import xyz.ragunath.nope.TestResult.Failed
import xyz.ragunath.nope.TestResult.Passed

open class ReturnValues {
  @Benchmark
  @BenchmarkMode(Throughput)
  fun returnValueTest(state: BenchmarkState): TestResult {
    return if (state.isTrue) {
      Passed("failingTest")
    } else {
      Failed("failingTest", "expected to be true, but was false")
    }
  }
}
