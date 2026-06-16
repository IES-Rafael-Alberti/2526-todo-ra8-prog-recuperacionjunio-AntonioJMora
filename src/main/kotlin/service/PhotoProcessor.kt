package org.iesra.service

import org.iesra.model.PhotoFile
import org.iesra.model.ProcessingResult
import org.iesra.model.ReflexPhotoFile
import org.iesra.model.RenameCommand
import org.iesra.model.SmartphonePhotoFile
import org.iesra.model.TripInput

class PhotoProcessor {
    fun process(input: TripInput) : ProcessingResult{
        val listaSmartPhone = buildValidSmartphonePhotos(input.smartphoneFiles)
        val listaReflex = buildValidReflexPhotos(input.reflexFiles)

        val photos = listaSmartPhone + listaReflex
        val orderedPhotos = photos.sortedBy { it.orderKey }

        val listaPhotos : MutableList<PhotoFile> = mutableListOf()
        var numeroPhoto = 0
        val renombradoPhotos = orderedPhotos.forEach { it.originalName to (input.place + "_" + numeroPhoto)
        numeroPhoto++
        listaPhotos.add(it)}

        val comandos = RenameCommand(photos.forEach { it.originalName }, listaPhotos.forEach { it.originalName })

        return ProcessingResult()
    }

    private fun buildValidSmartphonePhotos(names: List<String>) : List<PhotoFile> {
        val listaSmartphonePhotos: MutableList<PhotoFile> = mutableListOf()
        for (name in names) {
            try {
                SmartphonePhotoFile(name)
            }catch (e : Exception){
                println("Error: ${e.message}")
            }
        }
        return listaSmartphonePhotos
    }

    private fun buildValidReflexPhotos(names: List<String>) : List<PhotoFile> {
        val listaReflexPhotos: MutableList<PhotoFile> = mutableListOf()
        for (name in names) {
            try {
                listaReflexPhotos.add(ReflexPhotoFile(name))
            }catch (e : Exception){
                println("Error: ${e.message}")
            }
        }
        return listaReflexPhotos
    }
}