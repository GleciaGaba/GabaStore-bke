package p25.gabastore.api.dtos;

public class ProductCreate {
    private Long Id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Long categoryId;

    public ProductCreate() {

    }

    public Long getId() {
	return Id;
    }

    public void setId(Long id) {
	Id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
	return categoryId;
    }

    public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
    }

    @Override
    public String toString() {
	return String.format("{Id=%s,name=%s, description=%s, price=%s,imageUrl=%s, categoryId=%s}", Id, name,
		description, price, imageUrl, categoryId);
    }

}
