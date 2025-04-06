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
public class ShoppingCart {
    private List<OrderItem> cartItems;
    
    public ShoppingCart() {
        cartItems = new ArrayList<OrderItem>();
    }
    
    public List<OrderItem> getCartItems() {
        return cartItems;
    }
    
    public void addItem(OrderItem item) {
        // Check if product already exists in cart
        for (OrderItem existingItem : cartItems) {
            if (existingItem.getProduct().getModelNumber() == item.getProduct().getModelNumber()) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        
        // If not exists, add as new item
        cartItems.add(item);
    }
    
    public void removeItem(OrderItem item) {
        cartItems.remove(item);
    }
    
    public void updateItemQuantity(OrderItem item, int newQuantity) {
        if (newQuantity <= 0) {
            removeItem(item);
        } else {
            item.setQuantity(newQuantity);
        }
    }
    
    public void clear() {
        cartItems.clear();
    }
    
    public int getTotalAmount() {
        int total = 0;
        for (OrderItem item : cartItems) {
            total += item.getTotal();
        }
        return total;
    }
    
    public int getItemCount() {
        return cartItems.size();
    }
}
