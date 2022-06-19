package com.cyborg.nyc.core.mapper

abstract class Mapper<in I, out O> {
  abstract fun map(input: I): O
}
