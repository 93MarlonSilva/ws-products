package marlonsilvadev.app.com.ws_products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import marlonsilvadev.app.com.ws_products.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByName(String name);
}
