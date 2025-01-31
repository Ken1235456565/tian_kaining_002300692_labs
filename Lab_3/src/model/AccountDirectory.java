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

public class AccountDirectory {
    private ArrayList<Account> accounts;

    // 构造方法
    public AccountDirectory() {
        this.accounts = new ArrayList<>(); // 修正拼写错误
    }

    // 获取账户列表
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // 设置账户列表
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    // 添加账户并返回新账户
    public Account addAccount() {
        Account a = new Account();
        accounts.add(a);
        return a;
    }

    // 删除指定账户
    public void deleteAccount(Account account) {
        accounts.remove(account);
    }
    
    //查找账户
    public Account searchAccount(String accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber().contains(accountNumber)) {
                return a;
            }
        }
        return null;
    }
}

