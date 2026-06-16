package org.iesra.service

import org.iesra.model.PhotoFile
import org.iesra.model.ProcessingResult
import org.iesra.model.TripInput

class PhotoProcessor {
    fun process(input: TripInput) : ProcessingResult{
        buildValidSmartphonePhotos(input.smartphoneFiles)
        buildValidReflexPhotos(input.reflexFiles)

    }

    private fun buildValidSmartphonePhotos(names: List<String>) : List<PhotoFile> {

    }

    private fun buildValidReflexPhotos(names: List<String>) : List<PhotoFile> {

    }
}