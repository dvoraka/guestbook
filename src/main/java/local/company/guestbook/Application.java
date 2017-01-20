package local.company.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot runner.
 */
@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
