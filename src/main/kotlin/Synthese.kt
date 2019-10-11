inline class Synthese(val lignes: List<SyntheseLine>) {

    fun isHorseInTopPlaces(cheval: Int, numberOfPlaces: Int) =
        this.lignes
            .take(numberOfPlaces)
            .any { it.cheval == cheval }
}

data class SyntheseLine(val cheval: Int, val nbMentions: Int) {
    override fun toString() = "(cheval $cheval -> $nbMentions mentions)"
}

fun List<Pronostic>.toSynthese(): Synthese {
    return Synthese(
        this.flatMap { it.chevaux }
            .groupBy { it }
            .map { (cheval, mentions) -> SyntheseLine(cheval = cheval, nbMentions = mentions.count()) }
            .sortedByDescending { it.nbMentions }
    )
}
