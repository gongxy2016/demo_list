package com.demo.gong.mydemoapplication.DemoRecyclerViewFlow;

/**
 * Created by TS_02 on 2018/12/27.
 */

public class ShowImageBean {
    private String name;
    private int imageId;

    public ShowImageBean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "ShowImageBean{" +
                "name='" + name + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
