package pl.pw.mini.minispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MiNiSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiNiSpaceApplication.class, args);
    }

}
