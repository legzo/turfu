inline class Combinaison(val chevaux: Set<Int>) {
    override fun toString() = chevaux.toString()
}

fun List<Combinaison>.limitOccurencesTo(occurences: Int) =
    this.groupBy { it }
        .map { (combinaison, combinaisons) -> combinaison to combinaisons.count() }
        .filter { (_, count) -> count <= occurences }
        .map { (combinaison, _)  ->  combinaison }

fun List<Combinaison>.filterWithTopPlaceFromSynthese(numberOfPlaces: Int, synthese: Synthese) =
    this.filter { combinaison ->
        combinaison.chevaux.count { cheval ->
            synthese.isHorseInTopPlaces(cheval = cheval, numberOfPlaces = numberOfPlaces)
        } >= 2
    }