package me.omico.maven.util

import me.omico.maven.google.model.Group
import java.io.File
import java.io.FileOutputStream

fun ArrayList<Group>.excludeBlacklist(blackList: List<Regex>): List<Group> {
    val iterator = iterator()
    while (iterator.hasNext()) {
        val next = iterator.next()
        blackList.forEach { regex ->
            val matchResult = regex.matchEntire(next.id)
            if (matchResult != null) iterator.remove()
        }
    }
    return this
}

fun writeFile(fileName: String, text: String) {
    val saveFile = File(".", "$fileName.txt")
    val outStream = FileOutputStream(saveFile)
    outStream.write(text.toByteArray())
    outStream.close()
}
