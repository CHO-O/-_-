package com.course.term_project;

public class Item {
    String item_name;
    int image_id;

    public Item(int id, String name) {
        this.image_id = id;
        this.item_name = name;
    }

    public String getItemName() {
        return item_name;
    }

    public int getImageID() {
        return image_id;
    }

}