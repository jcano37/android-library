plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.pipeline.android.android.library"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    
    testOptions {
        targetSdk = 34
    }
    
    lint {
        targetSdk = 34
    }
}

dependencies {
    // Core Android dependencies
    api(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    
    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.pipeline.android"
            artifactId = "android-library"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("Android Utility Library")
                description.set("A modular and reusable Android library with utility functions")
                url.set("https://github.com/YOUR_USERNAME/android-library")
                
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                
                developers {
                    developer {
                        id.set("developer")
                        name.set("Developer Name")
                        email.set("developer@example.com")
                    }
                }
                
                scm {
                    connection.set("scm:git:git://github.com/YOUR_USERNAME/android-library.git")
                    developerConnection.set("scm:git:ssh://github.com:YOUR_USERNAME/android-library.git")
                    url.set("https://github.com/YOUR_USERNAME/android-library/tree/main")
                }
            }
        }
    }
    
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/YOUR_USERNAME/android-library")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}