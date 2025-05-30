package org.example.test;

public class objectB {
    public int test;
    public static int id;
    private objectA p;

    public objectB(int num) {
        test = num;
        id++;
        this.p = new objectA(3);
        this.p.check(this);
        //test
    }

    public void test() {
        System.out.println(this.test);

    }



}

