package marlonsilvadev.app.com.ws_products.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marlonsilvadev.app.com.ws_products.model.Product;

@RestController
@RequestMapping("/products")
public class produtoController {

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Product saved: " + product);

        return product;
    }

}
