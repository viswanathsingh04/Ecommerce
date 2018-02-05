package com.billiontags.ecom.model;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class GetItems {
    private List<Data> data;
    private String status;

    public GetItems() {
    }

    public GetItems(List<Data> data, String status) {
        this.data = data;
        this.status = status;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}