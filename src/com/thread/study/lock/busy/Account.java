/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.lock.busy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.naming.InsufficientResourcesException;

/**
 *
 * @author Administrator
 */
public class Account {

    String name;
    BusyFlag flag = new BusyFlag();
    static Map<String, Float> storage = new HashMap<>(0);

    static {
        storage.put("John", 1000F);
        storage.put("Mike", 800F);
    }

    static Map<String, Account> accounts = Collections.synchronizedMap(new HashMap<String, Account>());

    private Account(String name) {
        this.name = name;
    }

    public synchronized static Account getAccount(String name) {
        if (accounts.get(name) == null) {
            accounts.put(name, new Account(name));
        }

        return accounts.get(name);
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

    public void lock() {
        flag.getBusyFlag();
    }

    public void unlock() {
        flag.freeBusyFlag();
    }
}
