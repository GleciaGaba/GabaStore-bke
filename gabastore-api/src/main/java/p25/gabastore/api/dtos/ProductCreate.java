package p25.gabastore.api.dtos;

import p25.gabastore.api.entities.Category;

public class ProductCreate {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

    public ProductCreate() {

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

    public Category getCategory() {
	return category;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

    @Override
    public String toString() {
	return String.format("{name=%s, description=%s, price=%s,imageUrl=%s, category=%s}", name, description, price,
		imageUrl, category);
    }

}
