package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.Api;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! from app");


        Api api = new Api();

        api.print();
    }
}