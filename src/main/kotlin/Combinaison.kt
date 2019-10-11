inline class Combinaison(val value: Set<Int>)

fun allFrom(vararg combinaisons: List<Combinaison>) = combinaisons.toList().flatten()

fun List<Combinaison>.limitOccurencesTo(times: Int) =
    this.groupBy { it }
        .map { (combinaison, combinaisons) -> combinaison to combinaisons.count() }
        .filter { (_, count) -> count <= times }
        .toMap()