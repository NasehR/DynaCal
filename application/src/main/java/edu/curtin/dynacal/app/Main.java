package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.Api;
import edu.curtin.dynacal.calplugins.Repeat;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! from app");


        Api api = new Api();
        Repeat repeat = new Repeat();

        api.print();
        repeat.print();
    }
}