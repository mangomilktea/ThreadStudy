/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thread.study.lock.busy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class BusyFlag {

    protected Thread busyFlag = null;
    protected int busycount = 0;

    public synchronized void getBusyFlag() {
        while (!tryGetBusyFlag()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BusyFlag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private synchronized boolean tryGetBusyFlag() {
        if (busyFlag == null) {
            busyFlag = Thread.currentThread();
            busycount = 1;
            return true;
        }

        if (busyFlag.equals(Thread.currentThread())) {
            busycount++;
            return true;
        }
        return false;
    }

    public synchronized void freeBusyFlag() {
        if (getOwner() == Thread.currentThread()) {
            busycount--;
            if (busycount == 0) {
                busyFlag = null;
                notify();
            }
        }
    }

    public synchronized Thread getOwner() {
        return busyFlag;
    }
}
