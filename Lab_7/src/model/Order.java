/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tiankaining
 */
public class Order {
    private static int orderCounter = 0;
    
    private int orderNumber;
    private Customer customer;
    private Date orderDate;
    private List<OrderItem> orderItems;
    private String status; // New, Processing, Shipped, Delivered, Cancelled
    
    public Order(Customer customer) {
        orderCounter++;
        this.orderNumber = orderCounter;
        this.customer = customer;
        this.orderDate = new Date();
        this.orderItems = new ArrayList<OrderItem>();
        this.status = "New";
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }
    
    public void removeOrderItem(OrderItem item) {
        orderItems.remove(item);
    }
    
    public int getTotalAmount() {
        int total = 0;
        for (OrderItem item : orderItems) {
            total += item.getTotal();
        }
        return total;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
}
