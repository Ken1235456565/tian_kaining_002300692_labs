/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiankaining
 */
public class OrderDirectory {
    private List<Order> orderList;
    
    public OrderDirectory() {
        orderList = new ArrayList<Order>();
    }
    
    public List<Order> getOrderList() {
        return orderList;
    }
    
    public void addOrder(Order order) {
        orderList.add(order);
    }
    
    public void removeOrder(Order order) {
        orderList.remove(order);
    }
    
    public Order searchOrder(int orderNumber) {
        for (Order order : orderList) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }
    
    public List<Order> getCustomerOrders(Customer customer) {
        List<Order> customerOrders = new ArrayList<Order>();
        for (Order order : orderList) {
            if (order.getCustomer().equals(customer)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
}
