plugins {
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.21")

  testImplementation(kotlin("test-junit5"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
  testImplementation("com.google.truth:truth:1.1.2")
}

tasks.test {
  useJUnitPlatform()
}
