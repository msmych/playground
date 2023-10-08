subprojects {
    dependencies {
        if (project.name != "types") {
            implementation(project(":problems:types"))
        }
    }
}
