package p25.gabastore.api.services;

import p25.gabastore.api.dtos.ProductUpdate;

import java.util.List;
import p25.gabastore.api.dtos.ProductCreate;
import p25.gabastore.api.dtos.ProductItem;

public interface ProductService {

    void delete(Long id);

    void create(ProductCreate inputs);

    void update(Long id, ProductUpdate inputs);

    List<ProductItem> findItems();

    ProductItem getById(Long id);

}
