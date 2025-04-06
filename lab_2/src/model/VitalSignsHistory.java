/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author tiankaining
 */
public class VitalSignsHistory {
    private ArrayList<VitalSigns> history;

    // Constructor to initialize the history list
    public VitalSignsHistory() {
        history = new ArrayList<>();
    }
    
    //add sth to arraylist
    public VitalSigns addNewVitals() {
    VitalSigns newVs = new VitalSigns(); // 创建新的 Vitalsigns 对象
    history.add(newVs);                 // 将新对象添加到历史记录列表中
    return newVs;                       // 返回新创建的对象
    }
    
    // remove sth from history
    public void removeVitals(VitalSigns vs) {
        history.remove(vs);
    }

    // get the history list
    public ArrayList<VitalSigns> getHistory() {
        return history;
    }
    
}
