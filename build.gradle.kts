plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.16.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "Main"
    }
    archiveClassifier.set("all")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.javadoc {
    options.encoding = "UTF-8"
}