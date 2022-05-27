package p25.gabastore.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import p25.gabastore.api.dtos.ProductCreate;
import p25.gabastore.api.dtos.ProductItem;
import p25.gabastore.api.dtos.ProductUpdate;
import p25.gabastore.api.entities.Product;
import p25.gabastore.api.repositories.ProductRepository;
import p25.gabastore.api.dtos.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
	this.repository = repository;
    }

    @Override
    public List<ProductInfo> findInfos() {

	return repository.findAllProjectedByOrderByName(ProductInfo.class);
    }

    @Override
    public List<ProductItem> findItems() {

	return repository.findAllProjectedByOrderByName(ProductItem.class);
    }

    @Override
    @Transactional
    public void createProduct(ProductCreate inputs) {
	Product product = new Product();
	product.setName(inputs.getName());
	product.setDescription(inputs.getDescription());
	product.setPrice(inputs.getPrice());
	product.setImageUrl(inputs.getImageUrl());
	product.setCategory(inputs.getCategory());
	repository.save(product);
    }

    @Override
    public List<Product> getProducts() {
	return repository.findAllByOrderByName();

    }

    @Override
    public Product getById(Long id) {
	return repository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateProductById(Long id, ProductUpdate inputs) {
	Product product = repository.findById(id).get();
	product.setName(inputs.getName());
	product.setDescription(inputs.getDescription());
	product.setPrice(inputs.getPrice());
	product.setImageUrl(inputs.getImageUrl());
	product.setCategory(inputs.getCategory());
	repository.save(product);

    }

    @Override
    public List<ProductUpdate> getProductUpdate() {
	return repository.findAllProjectedBy(ProductUpdate.class);
    }

    @Override
    public Product updateStationById(Long id) {
	return repository.findById(id).get();
    }

    @Override
    public Product updateProductById(Long id) {
	return repository.findById(id).get();
    }

    @Override
    public List<Product> getItems() {
	return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
	repository.deleteById(id);

    }

}
