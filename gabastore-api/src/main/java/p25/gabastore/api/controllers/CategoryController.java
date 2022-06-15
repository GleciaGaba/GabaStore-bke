package p25.gabastore.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import p25.gabastore.api.dtos.CategoryView;
import p25.gabastore.api.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
	this.service = service;
    }

    @GetMapping
    public List<CategoryView> getItems() {
	return service.findItems();
    }
}
