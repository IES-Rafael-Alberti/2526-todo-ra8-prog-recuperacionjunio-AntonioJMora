package org.iesra.model

class SmartphonePhotoFile(originalName: String) : PhotoFile(originalName) {
    val partes = originalName.split("_", ".")
    override var orderKey: String = partes[1]+partes[2]
}