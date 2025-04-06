/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
public class VitalSigns {
    // Variable declarations
    String date;          
    double bloodPressure; 
    double temperature;   // with decimal
    int pulse;            // without
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public double getBloodPressure() {
        return bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public void setBloodPressure(double bloodPressure) {
    this.bloodPressure = bloodPressure;
    }
    
    @Override
    public String toString() {
        return getDate();
    }
}
