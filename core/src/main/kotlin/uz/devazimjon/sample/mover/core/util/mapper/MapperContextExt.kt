package uz.devazimjon.sample.mover.core.util.mapper

inline fun <Input : MapperContext, Output> List<Input>.mapIn(
    mapper: Input.() -> Mapper<Input, Output>
): List<Output> = this.map { it.mapIn { mapper(it) } }

inline fun <Input : MapperContext, Output> List<Input>.mapInNotNull(
    mapper: Input.() -> Mapper<Input, Output>
): List<Output> = this.mapNotNull { mapper(it).map() }

inline fun <Input : MapperContext, Output> Input.mapIn(
    mapper: Input.() -> Mapper<Input, Output>
): Output = mapper(this).map()

fun <Input, Output> Input.mapper(
    block: Input.() -> Output
): Mapper<Input, Output> = object : Mapper<Input,Output>() {
    override fun map() = block()
}
