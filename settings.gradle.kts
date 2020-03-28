rootProject.name = "maven-versions"

plugins {
    // https://plugins.gradle.org/plugin/com.gradle.enterprise
    id("com.gradle.enterprise") version "3.2"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"

        // Keep this while optimizing your builds,
        // but then remove it once you're done — unless you want to share all future builds with Gradle.
        // If removed, you can still get build scans by using the --scan option.
        publishAlways()
    }
}
