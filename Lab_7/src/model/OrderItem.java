/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
public class OrderItem {
    private Product product;
    private int quantity;
    private int salesPrice;
    
    public OrderItem(Product product, int quantity, int salesPrice) {
        this.product = product;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getSalesPrice() {
        return salesPrice;
    }
    
    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }
    
    public int getTotal() {
        return quantity * salesPrice;
    }
    
    @Override
    public String toString() {
        return product.getProdName();
    }
}
