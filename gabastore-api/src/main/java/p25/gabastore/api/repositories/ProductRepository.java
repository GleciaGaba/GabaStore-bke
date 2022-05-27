package p25.gabastore.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import p25.gabastore.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    <T> List<T> findAllProjectedByOrderByName(Class<T> type);

    List<Product> findAllByOrderByName();

    <T> List<T> findAllProjectedBy(Class<T> type);

}
