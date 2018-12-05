package com.assignments.adamdevenyi.secondproject;

import android.location.Address;

import java.util.List;
import java.util.Map;

public class Order {
    private String shop;
    private String orderType;
    private String address;
    private Float price;
    private List<String> pizza;

    public Order(){}

    public Order(String shop, String orderType, String address, List<String> pizza){
        this.shop = shop;
        this.orderType = orderType;
        this.address = address;
        this.pizza = pizza;

    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<String> getPizza() {
        return pizza;
    }

    public void setPizza(List<String> pizza) {
        this.pizza = pizza;
    }
}


