/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class Product {
    
    private String name;
    private int price;
    private int id;
    private ArrayList<Feature> features = new ArrayList<>();

    //this is a counter
    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
    public ArrayList<Feature> getFeatures() {
    return features;
    }
        
    public Feature findFeatureByName(String name) {
    for (Feature f : features) {
        if (f.getName().equals(name)) {
            return f; // 找到匹配的 Feature，返回它
        }
    }
    return null; // 没找到，返回 null
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public void removeFeature(Feature feature) {
        features.remove(feature);
    }
}
