/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.one;

/**
 *
 * @author Administrator
 */
public class WelcomeTest {

    public static void main(String[] args) {
        System.out.println("欢迎开始。。。。。");
        new WarmlyWelcome().start();
        System.out.println("欢迎到此结束！");
    }
}
