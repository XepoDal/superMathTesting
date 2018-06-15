package com.google;

public class mainClass {

    public static void main(String [] args) {
        testClass testClass = new testClass();
        try {
            testClass.test();
        } catch (InterruptedException e) {
            System.out.println("test 0 не запустился");
        }
    }

}
