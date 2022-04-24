import org.jetbrains.grammarkit.tasks.GenerateLexerTask
import org.jetbrains.grammarkit.tasks.GenerateParserTask

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.intellij") version "1.4.0"
    id("org.jetbrains.grammarkit") version "2021.2.2"
    id("org.sonarqube") version "3.3"
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
    version.set("2021.2")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
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
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
        dependsOn(generateACSLexer, generateACSParser)
    }

    withType(Test::class.java) {
        useJUnitPlatform()
    }

    patchPluginXml {
        sinceBuild.set("212")
        untilBuild.set("222.*")
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
        testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.8.2")
    }
}