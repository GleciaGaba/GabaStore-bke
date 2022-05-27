package p25.gabastore.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import p25.gabastore.api.dtos.ProductUpdate;
import p25.gabastore.api.entities.Product;
import p25.gabastore.api.dtos.ProductCreate;
import p25.gabastore.api.dtos.ProductItem;
import p25.gabastore.api.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
	this.service = service;
    }

    @GetMapping("/list")
    public List<ProductItem> listItems() {
	return service.findItems();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Long id) {
	return service.getById(id);
    }

    @GetMapping("/names")
    public List<Product> getProducts() {

	return service.getProducts();

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductCreate product) {
	service.createProduct(product);
    }

    @GetMapping("/update")
    public List<ProductUpdate> getProductUpdate() {
	return service.getProductUpdate();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductUpdate product) {
	service.updateProductById(id, product);
    }

    @GetMapping("/onlyid")
    public Product updateProductById(@PathVariable("id") Long id) {
	return service.updateProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
	service.deleteProductById(id);
    }

}
