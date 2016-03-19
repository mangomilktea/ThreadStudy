/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.timer.runnable;

/**
 *
 * @author Administrator
 */
public class TimerTest {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("启动线程，刷新随机数。。。");
        PrintNumberTimer printNumberTimer = new PrintNumberTimer();
        Thread timer = new Thread(printNumberTimer);
        timer.start();
        Thread.sleep(100L);
        printNumberTimer.setRunContinue(false);
        Thread.sleep(100L);
        System.out.println("线程结束！");
    }
}
