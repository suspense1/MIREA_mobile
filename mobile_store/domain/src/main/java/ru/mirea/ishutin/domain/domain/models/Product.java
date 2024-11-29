package ru.mirea.ishutin.domain.domain.models;

import java.util.List;
import java.util.Map;

public class Product {

    private List<String> images;
    private List<String> highlights;
    private int ref;
    private String bannerImage;
    private String id;
    private String type;
    private String brand;
    private String name;
    private int price;
    private int realPrice;
    private List<Map<String, String>> ratings;
    private String slug;
    private int __v;

    public String getImage() {
        return images.get(0);
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public int getRef() {
        return ref;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRealPrice() {
        return realPrice;
    }

    public List<Map<String, String>> getRatings() {
        return ratings;
    }

    public String getSlug() {
        return slug;
    }

    public static Product getProduct() {
        return new Product();
    }
}
