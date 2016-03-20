/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.join;

/**
 *
 * @author Administrator
 */
public class JoinTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("连接2执行中---" + i);
        }
        System.out.println("连接2执行结束。");
    }

}
