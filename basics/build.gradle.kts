plugins {
    id("com.stulsoft.pjava.java-library-conventions")
}

dependencies{
    implementation(project(":utils"))
    implementation("com.google.guava:guava:31.1-jre")
}