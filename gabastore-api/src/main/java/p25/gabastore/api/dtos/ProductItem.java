package p25.gabastore.api.dtos;

public interface ProductItem {

    Long getId();

    String getName();

    String getDescription();

    double getPrice();

    String getImageUrl();

    Long categoryId();
}
