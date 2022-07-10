plugins {
    // Apply the java Plugin to add support for Java.
    java
}

repositories {
    mavenCentral()
}

dependencies {
    val logVersion = "2.17.2"
//    val junitVersion = "5.8.2"

    implementation("org.apache.logging.log4j:log4j-core:$logVersion")
    implementation("org.apache.logging.log4j:log4j-api:$logVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$logVersion")
    implementation("org.apache.commons:commons-lang3:3.12.0")

//    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
//    testImplementation("org.junit.jupiter:junit-jupiter")

}

/*
tasks.test {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.8.1")
        }
    }}*/
