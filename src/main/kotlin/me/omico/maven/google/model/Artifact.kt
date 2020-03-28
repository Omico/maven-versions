package me.omico.maven.google.model

data class Artifact(
    val groupId: String,
    val id: String,
    val versions: List<String>
) {
    private val latestVersion = versions.last()

    fun toLatest(): String {
        return "$groupId:$id:$latestVersion"
    }
}
