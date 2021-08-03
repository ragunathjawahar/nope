package xyz.ragunath.nope

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FUNCTION

@Retention(RUNTIME)
@Target(FUNCTION)
annotation class Nope
