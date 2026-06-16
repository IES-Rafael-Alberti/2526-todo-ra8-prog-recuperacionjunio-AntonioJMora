package org.iesra.io

import org.iesra.model.TripInput
import java.io.File
import java.nio.file.Path

class InputFileReader {
    fun read(inputPath: Path): TripInput? {
        try {
            val ficheroLeido = File("$inputPath").readText()
            val fichero = TripInput(ficheroLeido[0].toString(), listOf(ficheroLeido[1].toString()), listOf(ficheroLeido[2].toString()))
            return fichero
        }catch (e: Exception){
            println("Error: No se ha podido leer el fichero")
            println(e)
            return null
        }
    }
}