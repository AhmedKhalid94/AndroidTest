package com.ahmed94.friends.Object;

/**
 * Created by Ahmed.
 */

public class ImageItem {

    private String name;
    private int image;

    private ImageItem() {
    }

    public ImageItem(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}