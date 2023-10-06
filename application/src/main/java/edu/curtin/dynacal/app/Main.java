package edu.curtin.dynacal.app;

import edu.curtin.dynacal.api.Api;
import edu.curtin.dynacal.calplugins.Repeat;
import edu.curtin.dynacal.calplugins.Notify;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! from app");


        Api api = new Api();
        Repeat repeat = new Repeat();
        Notify notify = new Notify();

        api.print();
        repeat.print();
        notify.print();

        for (String arg: args) {
            System.out.println(arg);
        }




        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}