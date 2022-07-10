plugins {
    id("com.stulsoft.pjava.java-library-conventions")
}

dependencies{
    implementation(project(":utils"))
}

testing{
    suites{
        val test by getting(JvmTestSuite::class){
            useJUnitJupiter("5.8.2")
        }
    }
}
