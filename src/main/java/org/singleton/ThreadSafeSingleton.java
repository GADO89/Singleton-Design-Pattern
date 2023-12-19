package org.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadSafeSingleton {

    private String[] LTTERS={"a","b","c","d","e"};
    private List<String> data= Arrays.asList(LTTERS);

    private static volatile ThreadSafeSingleton instance;

    private static boolean delayMe=true;

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance==null){
            if (delayMe){
                synchronized (ThreadSafeSingleton.class){
                    if (instance==null){
                    }
                    delayMe=false;
                    Thread.currentThread();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    }

            }
            instance=new ThreadSafeSingleton();
        }
        return instance;
    }

    ThreadSafeSingleton(){
        Collections.shuffle(data);
        PrintData();
    }

    public void PrintData() {
        for (String item:data){
            System.out.printf("%s",item);
        }
        System.out.println();
    }
}
