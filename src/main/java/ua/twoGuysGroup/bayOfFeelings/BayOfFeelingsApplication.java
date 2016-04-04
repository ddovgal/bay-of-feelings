package ua.twoGuysGroup.bayOfFeelings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class) //disable spring data rest endpoints
public class BayOfFeelingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BayOfFeelingsApplication.class, args);
	}
}
