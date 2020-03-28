package me.omico.maven.google.parser

import me.omico.maven.google.model.Artifact
import me.omico.maven.google.model.Group
import me.omico.maven.parser.XmlParser
import java.util.ArrayList

object GoogleMavenParser {

    fun parseGroups(xml: String): ArrayList<Group> {
        val document = XmlParser.createXmlParser(xml)
        return ArrayList<Group>().apply {
            XmlParser.getSingleElements(
                document
            ).forEach { add(Group(it.tagName())) }
        }
    }

    fun parseArtifacts(groupId: String, xml: String): List<Artifact> {
        val document = XmlParser.createXmlParser(xml)
        return ArrayList<Artifact>().apply {
            XmlParser.getSingleElements(document).forEach {
                add(
                    Artifact(
                        groupId = groupId,
                        id = it.tagName(),
                        versions = it.attr("versions").split(",").toList()
                    )
                )
            }
        }
    }
}
