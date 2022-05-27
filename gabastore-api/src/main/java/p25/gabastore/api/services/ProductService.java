package p25.gabastore.api.services;

import java.util.List;
import p25.gabastore.api.dtos.ProductItem;
import p25.gabastore.api.dtos.ProductUpdate;
import p25.gabastore.api.entities.Product;
import p25.gabastore.api.dtos.ProductCreate;
import p25.gabastore.api.dtos.ProductInfo;

public interface ProductService {

    List<ProductItem> findItems();

    List<ProductInfo> findInfos();

    List<Product> getProducts();

    List<ProductUpdate> getProductUpdate();

    Product getById(Long id);

    void createProduct(ProductCreate product);

    void updateProductById(Long id, ProductUpdate product);

    Product updateStationById(Long id);

    Product updateProductById(Long id);

    List<Product> getItems();

    void deleteProductById(Long id);
}
