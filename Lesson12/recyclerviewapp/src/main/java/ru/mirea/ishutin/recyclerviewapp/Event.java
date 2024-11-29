package ru.mirea.ishutin.recyclerviewapp;

public class Event {

    private String title;
    private String desc;
    private String imageId;

    public Event(String title, String desc, String imageId) {
        this.title = title;
        this.desc = desc;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageId() {
        return imageId;
    }
}
