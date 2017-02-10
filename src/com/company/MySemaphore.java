package com.company;

/**
 * Created by Tanusha on 10/02/2017.
 */
public class MySemaphore {
    boolean permit[] = { false, false, false };

    public synchronized void acquire (String param) throws InterruptedException {
        switch (param) {
            case "Cube":
                while (permit[0]) this.wait();
                permit[0] = true;
                break;
            case "Squre":
                while (permit[1]) this.wait();
                permit[1] = true;
                break;
            default:
                while (permit[2]) this.wait();
                permit[2] = true;
                break;
        }
    }

    public synchronized void release() {
        permit[0] = false;
        permit[1] = false;
        permit[2] = false;
        this.notifyAll();
    }
}
