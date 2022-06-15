package p25.gabastore.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import p25.gabastore.api.dtos.CategoryView;
import p25.gabastore.api.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getReferenceById(Long categoryId);

    List<CategoryView> findAllProjectedByOrderByName(Class<CategoryView> class1);

}
