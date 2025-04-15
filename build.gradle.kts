import net.ltgt.gradle.errorprone.errorprone

group = "com.github.alexandrenavarro"
version = "0.0.1-SNAPSHOT"

plugins {
    `java-library`
    `maven-publish`
    id("net.ltgt.errorprone") version "4.1.0"
}

repositories {
    mavenCentral()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.4.4"))

    errorprone("com.google.errorprone:error_prone_core:2.37.0")
    errorprone("com.uber.nullaway:nullaway:0.12.6")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.vavr:vavr:0.10.6")

    compileOnly("org.projectlombok:lombok:1.18.36")
    compileOnly("org.jspecify:jspecify:1.0.0")
    compileOnly("org.jetbrains:annotations:26.0.2")
    compileOnly("cc.jilt:jilt:1.8")

    annotationProcessor("org.projectlombok:lombok:1.18.36")
    annotationProcessor("cc.jilt:jilt:1.8")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<JavaCompile>().configureEach {
    options.errorprone {
        // Errorprone violations you must fix before using NullAway
        error("NullableOnContainingClass")
        error("NullableConstructor")
        error("NullableOptional")
        error("NullablePrimitive")
        error("NullablePrimitiveArray")
        error("NullableTypeParameter")
        error("NullableVoid")
        error("NullableWildcard")
        error("EqualsMissingNullable")
        error("FieldMissingNullable")
        error("ParameterMissingNullable")
        error("ReturnMissingNullable")
        error("VoidMissingNullable")
        error("NullableOnContainingClass")
        error("NullArgumentForNonNullParameter")

        // NullAway Configuration
        error("NullAway")
        option(
            "NullAway:AnnotatedPackages",
            "com.github.alexandrenavarro.marredesnullenjavadecouvreznullaway,org.springframework"
        )
        option("NullAway:ExcludedClassAnnotations", "org.jilt.JiltGenerated,jakarta.persistence.Entity")

        // Disable because of PresentationSample
        disable("UnusedVariable")

    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
