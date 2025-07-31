package marlonsilvadev.app.com.ws_products.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marlonsilvadev.app.com.ws_products.model.Product;
import marlonsilvadev.app.com.ws_products.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    private ProductRepository productRepository;

    public ProdutoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Product saved: " + product);
        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") String id) {
        System.out.println("Product ID requested: " + id);
        return productRepository.findById(id).orElse(null);
    }

}
