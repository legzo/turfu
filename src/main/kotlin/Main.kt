import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("Main")

fun main() {

    val pronostics = Loader("src/main/resources/pronos/pronos-01.txt").getPronostics()

    logger.info("Loaded : $pronostics")
    logger.info("Synthese : ${pronostics.toSynthese()}")

    val combinaisons1 = pronostics[0].toCombinaisons()
    logger.info("${combinaisons1.size} combinaisons 1er prono : $combinaisons1")
    val combinaisons2 = pronostics[1].toCombinaisons()
    logger.info("${combinaisons2.size} combinaisons 2eme prono : $combinaisons2")
    val combinaisons3 = pronostics[2].toCombinaisons()
    logger.info("${combinaisons3.size} combinaisons 3eme prono : $combinaisons3")

    val allCombinaisons  = combinaisons1 + combinaisons2 + combinaisons3

    logger.info("${allCombinaisons.size} combinaisons en tout")

    val limit = 1
    logger.info("${allCombinaisons.limitOccurencesTo(limit).size} combinaisons données moins de $limit fois")
    val limit2 = 2
    logger.info("${allCombinaisons.limitOccurencesTo(limit2).size} combinaisons données moins de $limit2 fois")
}