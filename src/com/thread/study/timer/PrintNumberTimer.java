/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.timer;

import java.text.MessageFormat;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class PrintNumberTimer extends Thread {

    private Boolean runContinue = true;
    private Random numRandom;

    public PrintNumberTimer() {
        numRandom = new Random();
    }

    @Override
    public void run() {
        while (runContinue) {
            if (runContinue) {
                System.out.println(MessageFormat.format("{0}-{1}-{2}-{3}-{4}-{5}-{6}-{7}", numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100), numRandom.nextInt(100)));
            } else {
                interrupt();
            }
        }
    }

    public void setRunContinue(Boolean runContinue) {
        this.runContinue = runContinue;
    }
}
