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
  fun init() {
    failingTest()
  }

  private fun failingTest(): TestResult {
    return if (false) {
      Passed("failingTest")
    } else {
      Failed("failingTest", "1 is not equal to 2")
    }
  }
}
