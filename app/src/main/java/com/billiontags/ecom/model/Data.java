package com.billiontags.ecom.model;

/**
 * Awesome Pojo Generator
 */
public class Data {
    private String item_img;
    private Integer item_id;
    private Integer price;
    private Integer crossed_price;
    private String item_name;

    public Data() {
    }

    public Data(String item_img, Integer item_id, Integer price, Integer crossed_price, String item_name) {
        this.item_img = item_img;
        this.item_id = item_id;
        this.price = price;
        this.crossed_price = crossed_price;
        this.item_name = item_name;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setCrossed_price(Integer crossed_price) {
        this.crossed_price = crossed_price;
    }

    public Integer getCrossed_price() {
        return crossed_price;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_name() {
        return item_name;
    }
}