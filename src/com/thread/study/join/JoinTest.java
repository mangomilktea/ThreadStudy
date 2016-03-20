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
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread join1 = new Thread(new JoinOne());
        Thread join2 = new Thread(new JoinTwo());
        join1.start();
        join1.join();
        join2.start();
        join2.join();
        System.out.println("线程连接测试结束。");
    }
}
