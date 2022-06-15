package p25.gabastore.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import p25.gabastore.api.dtos.ProductCreate;
import p25.gabastore.api.dtos.ProductItem;
import p25.gabastore.api.dtos.ProductUpdate;
import p25.gabastore.api.entities.Category;
import p25.gabastore.api.entities.Product;
import p25.gabastore.api.repositories.CategoryRepository;
import p25.gabastore.api.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository products;
    private final CategoryRepository categories;

    public ProductServiceImpl(ProductRepository products, CategoryRepository categories) {
	this.products = products;
	this.categories = categories;
    }

    @Override
    @Transactional
    public void create(ProductCreate inputs) {
	Product product = new Product();
	product.setName(inputs.getName());
	product.setDescription(inputs.getDescription());
	product.setPrice(inputs.getPrice());
	product.setImageUrl(inputs.getImageUrl());
	Category category = categories.getReferenceById(inputs.getCategoryId());
	product.setCategory(category);
	products.save(product);

    }

    @Override
    @Transactional
    public void update(Long id, ProductUpdate inputs) {
	Product product = products.findById(id).get();
	product.setName(inputs.getName());
	product.setDescription(inputs.getDescription());
	product.setPrice(inputs.getPrice());
	product.setImageUrl(inputs.getImageUrl());
	Category category = categories.getReferenceById(inputs.getCategoryId());
	product.setCategory(category);
	products.save(product);

    }

    @Transactional
    @Override
    public void delete(Long id) {
	products.deleteById(id);
    }

    @Transactional
    @Override
    public List<ProductItem> findItems() {
	return products.findAllProjectedByOrderByName(ProductItem.class);
    }

    @Override
    public ProductItem getById(Long id) {
	return products.findProjectedById(id);
    }

}
