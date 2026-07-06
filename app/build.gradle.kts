plugins {
    id("java")
    id("checkstyle")
    id("org.sonarqube") version "7.3.1.8318"
    id("jacoco")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))

    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Source: https://mvnrepository.com/artifact/com.github.ben-manes/gradle-versions-plugin
    runtimeOnly("com.github.ben-manes:gradle-versions-plugin:0.11.1")

    // Source: https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.20.0")

    // Source: https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:1.18.46")
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.4"
}

sonar {
    properties {
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.projectKey", "NeoEmo_java-project-78")
        property("sonar.organization", "neoemo")
        property("sonar.coverage.jacoco.xmlReportPaths", "${layout.buildDirectory.get()}/reports/jacoco/test/jacocoTestReport.xml")
    }
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
    }
}