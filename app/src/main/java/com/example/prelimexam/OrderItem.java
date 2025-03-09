package com.example.prelimexam;

public class OrderItem {
    private String productName;
    private int productImage;
    private String orderStatus;
    private String orderDate;
    private double totalPrice;

    public OrderItem(String productName, int productImage, String orderStatus, String orderDate, double totalPrice) {
        this.productName = productName;
        this.productImage = productImage;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public String getProductName() { return productName; }
    public int getProductImage() { return productImage; }
    public String getOrderStatus() { return orderStatus; }
    public String getOrderDate() { return orderDate; }
    public double getTotalPrice() { return totalPrice; }
}
