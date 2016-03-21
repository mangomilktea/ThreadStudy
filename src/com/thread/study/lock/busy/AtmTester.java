/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.lock.busy;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InsufficientResourcesException;

/**
 *
 * @author Administrator
 */
public class AtmTester {

    private static final int NUM_OF_ATM = 10;

    public static void main(String[] args) {
        AtmTester tester = new AtmTester();

        final Thread[] threads = new Thread[NUM_OF_ATM];
        final Atm[] atms = new Atm[NUM_OF_ATM];

        for (int i = 0; i < NUM_OF_ATM; i++) {
            atms[i] = new Atm();
            threads[i] = new Thread(tester.new Runner(atms[i]));
            threads[i].start();
        }
    }

    class Runner implements Runnable {

        Atm atm;

        Runner(Atm atm) {
            this.atm = atm;
        }

        @Override
        public void run() {

            atm.login("John");
            float bal = atm.getBalance();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtmTester.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("Your balance is:" + bal);
                System.out.println("withdraw:" + bal * 0.8f);
                atm.withdraw(bal * 0.8f);
                System.out.println("deposit:" + bal * 0.8f);
                atm.desposit(bal * 0.8f);
            } catch (InsufficientResourcesException ex) {
                System.out.println("余额不足！");
            } finally {
                atm.logout();
            }
        }

    }
}
