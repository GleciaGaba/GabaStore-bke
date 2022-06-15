package p25.gabastore.api.services;

import java.util.List;

import p25.gabastore.api.dtos.CategoryView;

public interface CategoryService {

    List<CategoryView> findItems();

}
