package com.company;

/**
 * Created by Tanusha on 10/02/2017.
 */
public class Square implements Runnable{
    private final int[] squareMas;
    private final Consumer consumers;
    private MySemaphore sem;

    public Square(int[] squareMas, Consumer consumers, MySemaphore sem) {
        this.squareMas = squareMas;
        this.consumers = consumers;
        this.sem = sem;
    }

    @Override
    public void run() {
        for (int i: squareMas) {
            try {
                sem.acquire("Squre");
                System.out.println("B = " + i + " B^2 = " + i*i);
                consumers.met(0, i*i, 0);
                Thread.sleep(1);//можно убрать, но тогда, я думаю, консоль не успевает выводить сообщения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
