package me.omico.maven.google.api

import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleMavenApi {

    @GET("master-index.xml")
    suspend fun getMasterIndexXml(): String

    @GET("{groupPath}/group-index.xml")
    suspend fun getGroupIndexXml(@Path("groupPath") groupPath: String): String

    @GET("{groupPath}/{artifactId}/{version}/{artifactId}-{version}.pom")
    suspend fun getArtifactPom(
        @Path("groupPath") groupPath: String,
        @Path("artifactId") artifactId: String,
        @Path("version") version: String
    ): String
}
