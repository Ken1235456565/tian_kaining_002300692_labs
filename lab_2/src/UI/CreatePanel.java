/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;
import javax.swing.JOptionPane;
import model.VitalSigns;
import model.VitalSignsHistory;

/**
 *
 * @author tiankaining
 */
public class CreatePanel extends javax.swing.JPanel {
    VitalSignsHistory vitalSignsHistory;

    /**
     * Creates new form CreatePanel
     */
    public CreatePanel(VitalSignsHistory vitalSignsHistory) {
        initComponents();
        this.vitalSignsHistory = vitalSignsHistory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTemp = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        txtBldP = new javax.swing.JTextField();
        lblBldP = new javax.swing.JLabel();
        txtPul = new javax.swing.JTextField();
        lblPul = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        lblTemp.setText("Temperature:");

        lblBldP.setText("Blood Pressure:");

        lblPul.setText("Pulse:");

        lblDate.setText("Date:");

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblTitle.setText("Create Vital Signs");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBldP)
                    .addComponent(lblPul)
                    .addComponent(lblTemp)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBldP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPul, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitle)
                        .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSave)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblTemp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBldP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBldP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        // Parse inputs from text fields
        double temperature = Double.parseDouble(txtTemp.getText());
        double bloodPressure = Double.parseDouble(txtBldP.getText());
        int pulse = Integer.parseInt(txtPul.getText());
        String date = txtDate.getText();

        // Create a new VitalSigns object
        VitalSigns newVs = vitalSignsHistory.addNewVitals();
        newVs.setTemperature(temperature);
        newVs.setBloodPressure(bloodPressure);
        newVs.setPulse(pulse);
        newVs.setDate(date);
        
        // 显示一个消息对话框
        JOptionPane.showMessageDialog(this, 
        "New Vital Signs created.", 
        "Success", 
        JOptionPane.INFORMATION_MESSAGE);
        
        //清空
        txtTemp.setText("");
        txtBldP.setText("");
        txtPul.setText("");
        txtDate.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblBldP;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPul;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtBldP;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtPul;
    private javax.swing.JTextField txtTemp;
    // End of variables declaration//GEN-END:variables
}
