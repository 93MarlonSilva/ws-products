package marlonsilvadev.app.com.ws_products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductapiApplication {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductapiApplication.class, args);
	}

}
