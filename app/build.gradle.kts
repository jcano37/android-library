plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.android.lib"
    compileSdk = 36

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
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }
    
    testOptions {
        targetSdk = 36
    }
    
    lint {
        targetSdk = 36
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

android {
    publishing {
        singleVariant("release") {
            withSourcesJar()
            // withJavadocJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.android"
            artifactId = "android-library"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("Android Library")
                description.set("Una librería Android modular y reutilizable con funciones utilitarias esenciales para el desarrollo de aplicaciones Android")
                url.set("https://github.com/jcano37/android-library")
                
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                
                developers {
                    developer {
                        id.set("jcano37")
                        name.set("Developer")
                        email.set("developer@example.com")
                        organization.set("Android Library")
                        organizationUrl.set("https://github.com/jcano37")
                    }
                }
                
                scm {
                    connection.set("scm:git:git://github.com/jcano37/android-library.git")
                    developerConnection.set("scm:git:ssh://git@github.com:jcano37/android-library.git")
                    url.set("https://github.com/jcano37/android-library")
                    tag.set("HEAD")
                }
                
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/jcano37/android-library/issues")
                }
                
                ciManagement {
                    system.set("GitHub Actions")
                    url.set("https://github.com/jcano37/android-library/actions")
                }
            }
        }
    }
    
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/jcano37/android-library")
            credentials {
                username = (project.findProperty("gpr.user") as String?)
                    ?: System.getenv("USERNAME")
                    ?: System.getenv("GITHUB_ACTOR")
                password = (project.findProperty("gpr.key") as String?)
                    ?: System.getenv("TOKEN")
                    ?: System.getenv("PERSONAL_ACCESS_TOKEN")
                    ?: System.getenv("GITHUB_TOKEN")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}