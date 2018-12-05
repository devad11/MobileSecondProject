package com.assignments.adamdevenyi.secondproject;

import android.location.Address;

import java.util.List;
import java.util.Map;

public class Order {
    private String shop;
    private String orderType;
    private String name;
    private String address;
    private String deliveryTime;
    private Float price;
    private List<String> pizza;

    public Order(){}

    public Order(String shop, String orderType, String name, String address, String deliveryTime, Float price, List<String> pizza){
        this.shop = shop;
        this.orderType = orderType;
        this.name = name;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    @Override
    public String toString() {
        return "Order{" +
                "shop='" + shop + '\'' +
                ", orderType='" + orderType + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", price=" + price +
                ", pizza=" + pizza +
                '}';
    }
}


