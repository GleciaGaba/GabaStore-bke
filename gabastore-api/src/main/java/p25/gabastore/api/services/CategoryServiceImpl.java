package p25.gabastore.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import p25.gabastore.api.dtos.CategoryView;

import p25.gabastore.api.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categories;

    public CategoryServiceImpl(CategoryRepository categories) {

	this.categories = categories;
    }

    @Transactional
    @Override
    public List<CategoryView> findItems() {
	return categories.findAllProjectedByOrderByName(CategoryView.class);
    }

}
