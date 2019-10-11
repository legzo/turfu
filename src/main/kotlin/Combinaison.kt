inline class Combinaison(val value: Set<Int>)

fun List<Combinaison>.limitOccurencesTo(times: Int) =
    this.groupBy { it }
        .map { (combinaison, combinaisons) -> combinaison to combinaisons.count() }
        .filter { (_, count) -> count <= times }
        .toMap()