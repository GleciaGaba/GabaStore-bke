package p25.gabastore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import p25.gabastore.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
