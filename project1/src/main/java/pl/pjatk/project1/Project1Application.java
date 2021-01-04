package pl.pjatk.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.*;
import org.springframework.context.annotation.*;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "pl.pjatk.project1.*")
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);

	}

}
