import org.jetbrains.grammarkit.tasks.GenerateLexerTask
import org.jetbrains.grammarkit.tasks.GenerateParserTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
    id("org.jetbrains.grammarkit") version "2021.2.2"
    id("org.sonarqube") version "3.3"
    id("com.adarshr.test-logger") version "3.2.0"
}

group = "by.home"
version = "1.0-SNAPSHOT"

apply {
    plugin("java")
    plugin("kotlin")
    plugin("jacoco")
    plugin("idea")
    plugin("org.jetbrains.grammarkit")
    plugin("org.jetbrains.intellij")
}

sonarqube.properties {
    property("sonar.projectKey", "COCONUTmkII_ActionCodeScriptPlugin")
    property("sonar.organization", "coconutmkii")
    property("sonar.host.url", "https://sonarcloud.io")
    property("sonar.exclusions", "**/src/main/gen/**/*.java")
}

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("2022.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf("java"))
}

sourceSets["main"].java.srcDir("src/main/gen")

val generateACSLexer = task<GenerateLexerTask>("GenerateLexer") {
    group = "grammar"
    source.set("src/main/grammar/ACS.flex")
    targetDir.set("src/main/gen/by/home/acs/language/lexer")
    targetClass.set("ACSLexer")
    purgeOldFiles.set(true)
}

val generateACSParser = task<GenerateParserTask>("GenerateParser") {
    group = "grammar"
    source.set("src/main/grammar/ACS.bnf")
    targetRoot.set("src/main/gen")
    pathToParser.set("by.home.acs.language.parser.ACSParser")
    pathToPsiRoot.set("by.home.acs.language.psi")
    purgeOldFiles.set(true)
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        dependsOn(generateACSLexer, generateACSParser)
    }

    withType<JacocoReport> {
        reports {
            xml.required.set(true)
            xml.outputLocation.set(file("$buildDir/reports/jacoco/test/jacocoTestReport.xml"))
            csv.required.set(false)
            html.required.set(false)
        }
    }

    withType(Test::class.java) {
        useJUnitPlatform()
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    dependencies {
        testImplementation("junit:junit:4.13.2")
        testImplementation("org.assertj:assertj-core:3.22.0")

        testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
        testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.9.1")
    }
}