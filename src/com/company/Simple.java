package com.company;

/**
 * Created by Tanusha on 10/02/2017.
 */
public class Simple implements Runnable{
    private final int[] simpleMas;
    private final Consumer consumers;
    private MySemaphore sem;

    public Simple(int[] simpleMas, Consumer consumers, MySemaphore sem) {
        this.simpleMas = simpleMas;
        this.consumers = consumers;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i: simpleMas) {
            try {
                sem.acquire("Simple");
                System.out.println("C = " + i);
                consumers.met(0, 0, i);
                Thread.sleep(1);//можно убрать, но тогда, я думаю, консоль не успевает выводить сообщения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
