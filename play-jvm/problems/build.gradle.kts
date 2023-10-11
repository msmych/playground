subprojects {
    dependencies {
        if (project.name != "utils") {
            implementation(project(":problems:utils"))
        }
    }
}
