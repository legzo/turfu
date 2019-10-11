inline class Synthese(val value: Map<Int, Int>)

fun List<Pronostic>.toSynthese(): Synthese {
    return Synthese(
        this.flatMap { it.chevaux }
            .groupBy { it }
            .map { (key, value) -> key to value.count() }
            .toMap()
    )
}