package com.juc;

/**
 * @author iuuui
 * @time 2024/03/28 0023
 */
public class ThreadUnsafeExample {

    private int count = 0;

    public void add() {
        count++;
    }

    public int get() {
        return count;
    }

}
