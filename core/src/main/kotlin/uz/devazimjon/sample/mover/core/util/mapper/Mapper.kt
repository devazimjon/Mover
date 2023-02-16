package uz.devazimjon.sample.mover.core.util.mapper

abstract class Mapper<Input, Output> {
    abstract fun map(): Output
}
