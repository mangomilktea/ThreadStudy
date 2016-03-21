/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.lock.busy;

import javax.naming.InsufficientResourcesException;

/**
 *
 * @author Administrator
 */
public class Atm {

    Account acc;

    public boolean login(String name) {
        if (acc != null) {
            throw new IllegalArgumentException("Already logged in!");
        }
        acc = Account.getAccount(name);
        acc.lock();
        return true;
    }

    public void desposit(float amt) {
        acc.deposit(amt);
    }

    public void withdraw(float amt) throws InsufficientResourcesException {
        acc.withdraw(amt);
    }

    public float getBalance() {
        return acc.getBalance();
    }

    public void logout() {
        acc.unlock();
        acc = null;
    }
}
