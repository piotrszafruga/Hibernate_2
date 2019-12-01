package pl.coderslab.dzien2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.coderslab.dzien2.model.Publisher;

@SpringBootApplication
public class Dzien2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Dzien2Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Dzien2Application.class);
	}

}
