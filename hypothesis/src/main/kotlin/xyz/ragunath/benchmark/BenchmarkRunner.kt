package xyz.ragunath.benchmark

class BenchmarkRunner {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      org.openjdk.jmh.Main.main(args)
    }
  }
}
