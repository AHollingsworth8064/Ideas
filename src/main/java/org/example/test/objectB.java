package org.example.test;

import java.io.File;

public class objectB {
    public int test;
    public static int id;
    private objectA p;



    public void test() {
        System.out.println(this.test);
        File test = new File("nope");
        System.out.println(test.exists()
        );
    }



}

