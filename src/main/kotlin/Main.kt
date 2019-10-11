import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("Main")

fun main() {

    simulate(
        filePath = "src/main/resources/pronos/pronos-01.txt",
        occurences = 1,
        topPlaceSynthese = 2
    )

}

private fun simulate(filePath: String, occurences: Int, topPlaceSynthese: Int) {
    val pronostics = Loader(filePath).getPronostics()
    logger.info("Chargement des pronostics : \n${pronostics.prettyPrint()}")

    val synthese = pronostics.toSynthese()
    logger.info("\nSynthese : \n${synthese.lignes.prettyPrint()}\n")

    val allCombinaisons = pronostics.flatMap {
        val combinaisons = it.toCombinaisons()
        logger.info("${combinaisons.size} combinaisons pour $it, combinaisons -> $combinaisons")
        combinaisons
    }

    logger.info("${allCombinaisons.size} combinaisons en tout")

    val combinationsFilteredByPopularity = allCombinaisons.limitOccurencesTo(occurences)
    logger.info("\n${combinationsFilteredByPopularity.size} combinaisons données au plus $occurences fois")

    val combinationsFilteredByPopularityAndSynthese =
        combinationsFilteredByPopularity.filterWithTopPlaceFromSynthese(topPlaceSynthese, synthese)

    logger.info("\n${combinationsFilteredByPopularityAndSynthese.size} combinaisons après filtre par la synthèse (top $topPlaceSynthese)")

    logger.info("\nCombinaisons finales: \n${combinationsFilteredByPopularityAndSynthese.prettyPrint()}")
}

fun List<Any>.prettyPrint() = this.joinToString(separator = "\n") { "  $it" }