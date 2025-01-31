/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.AccountManager;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.AccountDirectory;

/**
 *
 * @author tiankaining
 */
public class AccountMngWorkAreaJPanel extends javax.swing.JPanel {
    // 成员变量
    JPanel userProcessContainer; // 用于存储传入的容器对象
    AccountDirectory accountDirectory; // 用于存储传入的账户数据管理对象
    
    /**
     * Creates new form AccountMngWorkAreaJPanel
     */
    public AccountMngWorkAreaJPanel(JPanel container, AccountDirectory directory) {
        initComponents();
        userProcessContainer = container;
        accountDirectory = directory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateAccount = new javax.swing.JButton();
        btnManageAccount = new javax.swing.JButton();

        setBounds(new java.awt.Rectangle(0, 0, 190, 23));

        btnCreateAccount.setText("Create Account");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        btnManageAccount.setText("Manage Account");
        btnManageAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCreateAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageAccount)
                .addContainerGap(455, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        // TODO add your handling code here:
        // 1. 创建一个新的 CreateAccountJPanel 实例
        CreateAccountJPanel panel = new CreateAccountJPanel(userProcessContainer, accountDirectory);
        // 2. 将面板添加到 userProcessContainer 中
        userProcessContainer.add("CreateAccountJPanel", panel);
        // 3. 获取 CardLayout
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        // 4. 切换到新创建的面板
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnManageAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAccountActionPerformed
        // TODO add your handling code here:
        // 1. 创建一个新的 AccountMngWorkAreaJPanel 实例
        ManageAccountsJPanel panel = new ManageAccountsJPanel(userProcessContainer, accountDirectory);
        // 2. 将面板添加到 userProcessContainer 中，并命名为 "AccountMngWorkAreaJPanel"
        userProcessContainer.add("AccountMngWorkAreaJPanel", panel);
        // 3. 获取 userProcessContainer 的布局管理器（必须是 CardLayout）
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        // 4. 切换到下一张卡片
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnManageAccount;
    // End of variables declaration//GEN-END:variables
}
