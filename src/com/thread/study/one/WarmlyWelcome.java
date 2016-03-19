/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.one;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class WarmlyWelcome extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                System.out.println("欢迎！欢迎！热烈欢迎 " + i + "！");
                sleep(1L);
            } catch (InterruptedException ex) {
                Logger.getLogger(WarmlyWelcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
