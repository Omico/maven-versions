package me.omico.maven.google

/**
 * Those repositories currently are deprecated.
 */
val googleBlacklist = listOf(
    "(android\\..*)".toRegex(),
    "(androidx\\.localbroadcastmanager)".toRegex(),
    "(com\\.android\\.support*)".toRegex(),
    "(com\\.android\\.support\\..*)".toRegex(),
    "(com\\.crashlytics\\.sdk\\.android)".toRegex(),
    "(io\\.fabric\\.sdk\\.android)".toRegex(),
    "(org\\.jetbrains\\.kotlin)".toRegex()
)