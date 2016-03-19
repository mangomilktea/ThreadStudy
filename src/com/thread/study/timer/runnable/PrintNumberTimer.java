/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.timer.runnable;

import java.text.MessageFormat;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class PrintNumberTimer implements Runnable {

    private Random numRandom;
    private static boolean runContinue = true;

    public PrintNumberTimer() {
        numRandom = new Random();
    }

    @Override
    public void run() {
        while (runContinue) {
            System.out.println(MessageFormat.format("{0}-{1}-{2}-{3}-{4}-{5}-{6}-{7}", numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100)));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("启动线程，刷新随机数。。。");
        Thread timer = new Thread(new PrintNumberTimer());
        timer.start();
        Thread.sleep(100L);
        runContinue = false;
        Thread.sleep(100L);
        System.out.println("线程结束！");
    }
}
