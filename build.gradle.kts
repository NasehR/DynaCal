plugins {
    id("application")
}

repositories {
    mavenCentral()
}

dependencies{
    implementation(project(":lib"))
}

application {
    mainClass = "edu.curtin.dynacal.Main"
}