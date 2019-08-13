import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.0.M5"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	kotlin("jvm") version "1.3.41"
	kotlin("plugin.spring") version "1.3.41"
}

group = "com.github.acehjm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "Hoxton.M1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-quartz")
	implementation("org.springframework.boot:spring-boot-starter-rsocket")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0")
	implementation("org.springframework.cloud:spring-cloud-bus")
	implementation("org.springframework.cloud:spring-cloud-config-server")
	implementation("org.springframework.cloud:spring-cloud-starter")
	implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix-dashboard")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-ribbon")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-turbine")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-turbine-stream")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-zuul")
	implementation("org.springframework.cloud:spring-cloud-starter-oauth2")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.springframework.cloud:spring-cloud-starter-security")
	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springframework.cloud:spring-cloud-starter-task")
	implementation("org.springframework.cloud:spring-cloud-starter-zipkin")
	implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
	implementation("org.springframework.cloud:spring-cloud-stream-binder-rabbit")
	implementation("org.springframework.kafka:spring-kafka")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("mysql:mysql-connector-java")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
