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

rootProject.name = "Lesson6"
include(":app")
include(":SecureSharedPreferences")
include(":InteralFileStorage")
include(":Notebook")
include(":EmployeeDB")
