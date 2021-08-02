plugins {
  kotlin("jvm")
  kotlin("kapt")
  application
}

application {
  mainClass.set("xyz.ragunath.benchmark.BenchmarkRunner")
}

dependencies {
  implementation(kotlin("stdlib"))

  implementation("org.openjdk.jmh:jmh-core:1.32")
  kapt("org.openjdk.jmh:jmh-generator-annprocess:1.32")

  implementation("com.google.truth:truth:1.1.3") {
    because("benchmarking code is in the main source set")
  }
}
