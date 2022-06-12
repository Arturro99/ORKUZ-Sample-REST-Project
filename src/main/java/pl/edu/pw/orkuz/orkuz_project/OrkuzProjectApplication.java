package pl.edu.pw.orkuz.orkuz_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OrkuzProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrkuzProjectApplication.class, args);
    }

}
