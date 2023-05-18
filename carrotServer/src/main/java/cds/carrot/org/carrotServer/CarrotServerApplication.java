package cds.carrot.org.carrotServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CarrotServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrotServerApplication.class, args);
	}

}
