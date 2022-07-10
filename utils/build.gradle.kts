plugins {
    id("com.stulsoft.pjava.java-library-conventions")
}

testing{
    suites{
        val test by getting(JvmTestSuite::class){
            useJUnitJupiter("5.8.2")
        }
    }
}
