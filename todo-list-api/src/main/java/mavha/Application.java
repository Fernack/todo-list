package mavha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by fnatalino on 16/4/2019.
 */

@SpringBootApplication(scanBasePackages = {"mavha.domain", "mavha.resources"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}