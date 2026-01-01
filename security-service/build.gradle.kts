plugins {
	java
	id("org.springframework.boot") version "3.3.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// === SPRING BOOT STARTERS ===
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// === JACKSON (JSON handling) ===
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")
	implementation("com.fasterxml.jackson.core:jackson-databind")

	// === JWT (JSON Web Tokens) ===
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// === LOMBOK ===
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// === MAPSTRUCT ===
	implementation("org.mapstruct:mapstruct:1.6.3")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

	// === DATABASE ===
	runtimeOnly("org.postgresql:postgresql")
	implementation("jakarta.persistence:jakarta.persistence-api")

	// === SPRING CLOUD ===
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

	// === TESTING ===
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
