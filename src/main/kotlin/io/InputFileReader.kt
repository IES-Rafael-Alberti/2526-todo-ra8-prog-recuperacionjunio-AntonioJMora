package org.iesra.io

import org.iesra.model.TripInput
import java.io.File
import java.nio.file.Path

class InputFileReader {
    fun read(inputPath: Path): TripInput? {
        try {
            val ficheroLeido = File("$inputPath").readLines()
            val nombresSmart = ficheroLeido[1].split(" ")
            val nombresReflex = ficheroLeido[2].split(" ")
            val fichero = TripInput(ficheroLeido[0], nombresSmart, nombresReflex)

            // TODO: hacer validaciones de que sean 3 lineas, que la primera linea sea solo una palabra
            return fichero
        }catch (e: Exception){
            println("Error: No se ha podido leer el fichero")
            println(e)
            return null
        }
    }
}