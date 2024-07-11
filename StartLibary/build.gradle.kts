plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.start.startlibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    publishing {
        singleVariant("release")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Artur199324"
                artifactId = "StartLibrary"
                version = "1.0.17"

                pom {
                    name.set("StartLibrary")
                    description.set("A simple Android library")
                    url.set("https://github.com/Artur199324/StartLibrary")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("Artur199324")
                            name.set("Artur")
                            email.set("artur@example.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:git://github.com/Artur199324/StartLibrary.git")
                        developerConnection.set("scm:git:ssh://github.com/Artur199324/StartLibrary.git")
                        url.set("https://github.com/Artur199324/StartLibrary")
                    }
                    withXml {
                        asNode().appendNode("pluginRepositories").apply {
                            appendNode("pluginRepository").apply {
                                appendNode("id", "maven-snapshots")
                                appendNode("url", "https://repository.apache.org/content/repositories/snapshots/")
                            }
                            appendNode("pluginRepository").apply {
                                appendNode("id", "maven-shade-plugin")
                                appendNode("url", "https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-shade-plugin")
                            }
                        }
                    }
                }
            }
        }

        repositories {
            mavenLocal()
            maven {
                name = "jitpack"
                url = uri("https://jitpack.io")
            }
        }
    }
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}