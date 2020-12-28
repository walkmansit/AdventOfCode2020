plugins {
    application
    id("com.github.ben-manes.versions")
    id("io.gitlab.arturbosch.detekt")
    id("me.champeau.gradle.jmh")
    id("org.jetbrains.dokka")
    id("org.jmailen.kotlinter")
    kotlin("jvm")
}
repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

application {
    mainClassName = "github.walkmansit.aoc2020.StarterKt"
    // applicationDefaultJvmArgs = listOf("-Xmx1536m")
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "github.walkmansit.aoc2020.StarterKt"
    }
}

defaultTasks = listOf("check", "run") as MutableList<String>

dependencies {
    val guavaVersion: String by project
    val junitVersion: String by project
    val kotlinxCoroutinesVersion: String by project
    val truthVersion: String by project


    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.guava:guava:$guavaVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    testImplementation(kotlin("test-junit5"))
    testImplementation("com.google.truth:truth:$truthVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinxCoroutinesVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    jmhImplementation(kotlin("reflect"))
    jmhImplementation(kotlin("stdlib-jdk8"))
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "11"
    targetCompatibility = "11"
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

kotlinter {
    ignoreFailures = project.hasProperty("lintContinueOnError")
    experimentalRules = project.hasProperty("lintKotlinExperimental")
}

detekt {
    val detektVersion: String by project
    toolVersion = detektVersion
    config = rootProject.files("detekt.yml")
    buildUponDefaultConfig = true
    baseline = rootProject.file("detekt-baseline.xml")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
        warn.events("PASSED", "FAILED", "SKIPPED", "STANDARD_ERROR")
        info.events("PASSED", "FAILED", "SKIPPED", "STANDARD_ERROR", "STANDARD_OUT")
        debug.events("PASSED", "FAILED", "SKIPPED", "STANDARD_ERROR", "STANDARD_OUT", "STARTED")
    }
    // jvmArgs("-Xmx1536m")
}

val jmhExclude: String? by project
val jmhInclude: String? by project

jmh {
    benchmarkMode = listOf("sample")
    if (!jmhExclude.isNullOrEmpty()) exclude = listOf(jmhExclude)
    if (!jmhInclude.isNullOrEmpty()) include = listOf(jmhInclude)
    duplicateClassesStrategy = DuplicatesStrategy.WARN
    fork = 1
    threads = 1
    timeOnIteration = "1s"
    timeUnit = "ns"
    warmupIterations = 1
}
