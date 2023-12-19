package org.singleton;

public class Driver {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        /*LazySingleton inst1= LazySingleton.getInstance();
        LazySingleton inst2= LazySingleton.getInstance();

        System.out.println(inst1.hashCode());
        inst1.PrintData();
        System.out.println(inst2.hashCode());
        inst2.PrintData();*/

        new DataPrinter().start();
        new DataPrinter().start();
    }
}

class DataPrinter extends Thread{

    @Override
    public void run() {
        ThreadSafeSingleton.getInstance().PrintData();
    }
}