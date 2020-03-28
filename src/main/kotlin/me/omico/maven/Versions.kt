@file:JvmName("Versions")

package me.omico.maven

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.omico.maven.google.api.GoogleMavenService
import me.omico.maven.google.googleBlacklist
import me.omico.maven.google.parser.GoogleMavenParser
import me.omico.maven.util.excludeBlacklist
import me.omico.maven.util.writeFile
import kotlin.system.exitProcess

suspend fun main() {
    writeGoogleVersions()
    exitProcess(0)
}

suspend fun writeGoogleVersions() {
    val buffer = StringBuffer()
    val masterIndexXml = GoogleMavenService.createGoogleMavenApi().getMasterIndexXml()
    val groups = GoogleMavenParser.parseGroups(masterIndexXml)
        .excludeBlacklist(googleBlacklist)
        .sortedBy { group -> group.id }
    groups.forEachIndexed { index, group ->
        println("(${index + 1}/${groups.size}) ${group.id}")
        buffer.appendln(group.id)
        withContext(Dispatchers.IO) {
            val groupIndexXml = GoogleMavenService.createGoogleMavenApi().getGroupIndexXml(group.id.replace(".", "/"))
            GoogleMavenParser.parseArtifacts(group.id, groupIndexXml).sortedBy { artifact -> artifact.id }
        }.forEach {
            println(it.toLatest())
            buffer.appendln(it.toLatest())
        }
        println()
        buffer.appendln()
    }
    writeFile("google", buffer.toString())
}
