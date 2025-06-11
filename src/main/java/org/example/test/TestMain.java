package org.example.test;


import org.example.FileHelper.fileInfo;

import java.io.File;

public class TestMain {

    public static void main(String[] args) {
//        File test = new File("/Users/ahollingsworth8064/IdeaProjects/Ideas/src/main/java/org/example/test/objectB.java");
//        System.out.println(test.exists());
//
//
        File theta = new File("");
        System.out.println(theta.getAbsolutePath() + " , " + theta.exists());
        objectB e = new objectB();
        objectA pi = new objectA(1);
//        fileInfo.getMethodCaller(e);
        pi.check(e);





    }
}