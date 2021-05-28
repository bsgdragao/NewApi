package one.digitalinovation.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class RestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProjectApplication.class, args);
	}
	
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("")
				.version("1.0")
				.termsOfService("")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
