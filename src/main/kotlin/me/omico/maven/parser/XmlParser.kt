package me.omico.maven.parser

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

object XmlParser {

    fun createXmlParser(xml: String): Document {
        return Jsoup.parse(xml, "", Parser.xmlParser())
    }

    fun getSingleElements(document: Document): Elements {
        return document.children()[0].children()
    }
}
