import java.io.File

class Loader(private val filePath: String) {

    fun getPronostics() = File(filePath)
        .readLines()
        .map { line ->
            val tokens = line.split(' ')
            Pronostic(tokens[0], tokens.drop(1).map { it.toInt() })
        }

}

