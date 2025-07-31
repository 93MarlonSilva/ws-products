package marlonsilvadev.app.com.ws_products.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marlonsilvadev.app.com.ws_products.model.Product;
import marlonsilvadev.app.com.ws_products.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    private ProductRepository productRepository;

    public ProdutoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Product product) {
        try {
            System.out.println("Product saved: " + product);
            var id = UUID.randomUUID().toString();
            product.setId(id);

            productRepository.save(product);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing product ID: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> get(@PathVariable("id") String id) {
        try {
            System.out.println("Product ID requested: " + id);
            return ResponseEntity.ok(productRepository.findById(id).orElse(null));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing product ID: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {

            if (!productRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }

            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            if (!productRepository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            product.setId(id);
            System.out.println("Product updated: " + product);
            productRepository.save(product);

            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getList(@RequestParam("name") String name) {
        try {
            return ResponseEntity.ok(productRepository.findByName(name));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
