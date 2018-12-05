package com.assignments.adamdevenyi.secondproject;

import java.util.List;

public class Order {
    private String shop;
    private String orderType;
    private String name;
    private String address;
    private String pNum;
    private String deliveryTime;
    private Double price;
    private List<String> pizza;

    public Order(){
        this.deliveryTime = "n/a";
    }

    public Order(String shop, String orderType, String name, String address, String pNum, String deliveryTime, Double price, List<String> pizza){
        this.shop = shop;
        this.orderType = orderType;
        this.name = name;
        this.address = address;
        this.pNum = pNum;
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

    public String getpNum() { return pNum;  }

    public void setpNum(String pNum) { this.pNum = pNum;  }

    public String getDeliveryTime() { return deliveryTime; }

    public void setDeliveryTime(String deliveryTime) { this.deliveryTime = deliveryTime; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

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
                ", pNum='" + pNum + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", price=" + price +
                ", pizza=" + pizza +
                '}';
    }
}


