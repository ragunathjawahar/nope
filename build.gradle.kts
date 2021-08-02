import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    mavenCentral()
    jcenter()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.2")
  }
}

plugins {
  kotlin("jvm") version "1.5.21" apply false
  kotlin("kapt") version "1.5.21" apply false
}

allprojects {
  group = "xyz.ragunath"
  version = "0.1.0-SNAPSHOT"

  tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "1.8"
    }
  }
}

subprojects {
  repositories {
    mavenCentral()
  }
}
