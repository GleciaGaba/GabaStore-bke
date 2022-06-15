package p25.gabastore.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p25.gabastore.api.dtos.ProductUpdate;
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
    public List<ProductItem> getItems() {
	return service.findItems();
    }

    @GetMapping("/{id}")
    public ProductItem getById(@PathVariable("id") Long id) {
	return service.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody ProductCreate inputs) {
	service.create(inputs);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ProductUpdate inputs) {
	service.update(id, inputs);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

}
