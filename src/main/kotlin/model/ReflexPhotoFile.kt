package org.iesra.model

class ReflexPhotoFile(originalName: String) : PhotoFile(originalName) {
    val partes1 = originalName.split("P")
    val partes2 = partes1[1].split("_")
    val partesAno = partes2[0].split("DD", "MM", "YY")
    val ordenadas = "20" + partesAno[2] + partesAno[1] + partes1[0]

    override var orderKey: String = ordenadas + partes2[1]
}