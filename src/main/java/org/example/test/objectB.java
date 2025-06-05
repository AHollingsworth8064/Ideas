package org.example.test;

import javax.swing.*;
import java.io.File;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class objectB {
    public int test;
    public static int id;
    private objectA p;

//    public void test() {
//        System.out.println(this.test);
//        File test = new File("nope");
//        System.out.println(test.exists()
//        );
//    }
    public void test(Object obj){
        JFrame q = new JFrame();
        objectA p = new objectA(1);
        p.wt(q);
    }




}

