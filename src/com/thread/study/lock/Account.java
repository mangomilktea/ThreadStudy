/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.lock;

import java.util.HashMap;
import java.util.Map;
import javax.naming.InsufficientResourcesException;

/**
 *
 * @author Administrator
 */
public class Account {

    String name;
    static Map<String, Float> storage = new HashMap<>(0);

    static {
        storage.put("John", 1000F);
        storage.put("Mike", 800F);
    }

    public Account(String name) {
        this.name = name;
    }

    public synchronized void deposit(float amt) {
        float amount = storage.get(name);
        storage.put(name, amount + amt);
    }

    public synchronized void withdraw(float amt) throws InsufficientResourcesException {
        float amount = storage.get(name);
        if (amount >= amt) {
            amount -= amt;
            storage.put(name, amount);
        } else {
            throw new InsufficientResourcesException();
        }
    }

    public Float getBalance() {
        return storage.get(name);
    }
}
