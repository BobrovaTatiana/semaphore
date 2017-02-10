package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        MySemaphore sem = new MySemaphore();
        Consumer consumers = new Consumer(sem);

        int[] intsA = {2, 2, 3};
        int[] intsB = {4, 5, 6};
        int[] intsC = {7, 8, 9};

        new Thread(new Cube(intsA, consumers, sem)).start();
        new Thread(new Square(intsB, consumers, sem)).start();
        new Thread(new Simple(intsC, consumers, sem)).start();
    }
}
