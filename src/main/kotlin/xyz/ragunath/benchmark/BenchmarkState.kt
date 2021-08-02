package xyz.ragunath.benchmark

import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class BenchmarkState(val isTrue: Boolean = false)
