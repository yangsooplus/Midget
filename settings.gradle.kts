pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Midget"
include(":app")
include(":widget")
include(":feature-home")
include(":feature-custom")
include(":data")
include(":database")
include(":ui")
include(":model")
