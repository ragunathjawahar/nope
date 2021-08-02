import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
  kotlin("jvm") version "1.5.21"
  kotlin("kapt") version "1.5.21"
}

group = "xyz.ragunath"
version = "0.1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")

  implementation("org.openjdk.jmh:jmh-core:1.28")
  kapt("org.openjdk.jmh:jmh-generator-annprocess:1.28")

  implementation("com.google.truth:truth:1.1.3")
}
