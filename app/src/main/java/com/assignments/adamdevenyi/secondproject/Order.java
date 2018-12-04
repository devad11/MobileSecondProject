package com.assignments.adamdevenyi.secondproject;

import android.location.Address;

import java.util.Map;

public class Order {
    private String shop;
    private String orderType;
    private String address;
    private String[] pizza;

    public Order(){}

    public Order(Integer[] toppings){
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

    public String[] getPizza() {
        return pizza;
    }

    public void setPizza(String[] pizza) {
        this.pizza = pizza;
    }
}


