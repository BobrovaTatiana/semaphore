package com.company;

/**
 * Created by Tanusha on 10/02/2017.
 */
public class Consumer {
    static int summ = 0;
    static int mCube = 0;
    static int mSquare = 0;
    static int mSimple = 0;
    private MySemaphore sem;

    public Consumer(MySemaphore sem) {
        this.sem = sem;
    }

    public void met (int cube, int sq, int simple) {
        mCube += cube;
        mSquare += sq;
        mSimple += simple;
        summ += cube + sq + simple;
        if (mCube!=0 && mSquare!=0 && mSimple!=0){
            System.out.println("Итого: " + mCube + " + " + mSquare + " + " + mSimple + " = " + summ + "\n");
            mCube = 0;
            mSquare = 0;
            mSimple = 0;
            summ = 0;
            sem.release();
        }
    }
}
