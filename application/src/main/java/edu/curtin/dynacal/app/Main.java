package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.Api;
import edu.curtin.dynacal.calplugins.Repeat;
import edu.curtin.dynacal.calplugins.Notify;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! from app");


        Api api = new Api();
        Repeat repeat = new Repeat();
        Notify notify = new Notify();

        api.print();
        repeat.print();
        notify.print();
    }
}