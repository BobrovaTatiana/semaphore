package com.company;

/**
 * Created by Tanusha on 10/02/2017.
 */
public class Cube implements Runnable {
    private final int[] cubeMas;
    private final Consumer consumers;
    private MySemaphore sem;

    public Cube(int[] cubeMas, Consumer consumers, MySemaphore sem) {
        this.cubeMas = cubeMas;
        this.consumers = consumers;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i: cubeMas) {
            try {
                sem.acquire("Cube");
                System.out.println("A = " + i + " A^3 = " + i*i*i);
                consumers.met(i*i*i, 0, 0);
                Thread.sleep(1);//можно убрать, но тогда, я думаю, консоль не успевает выводить сообщения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
