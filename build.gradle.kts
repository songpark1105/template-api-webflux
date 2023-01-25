import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}

    all {
        exclude("org.apache.logging.log4j", "log4j-to-slf4j")
    }
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlinLogging = "3.0.4"
	val commonsIo = "2.11.0"
	val commonsText = "1.10.0"
	val guava = "31.1-jre"
	val jsonwebtoken = "0.11.5"

	implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLogging")

	implementation("commons-io:commons-io:$commonsIo")
	implementation("org.apache.commons:commons-text:$commonsText")
	implementation("org.apache.commons:commons-lang3")

	implementation("com.google.guava:guava:$guava")

	implementation("io.jsonwebtoken:jjwt-api:$jsonwebtoken")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:$jsonwebtoken")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jsonwebtoken")

	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
//	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.postgresql:r2dbc-postgresql")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
//	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
