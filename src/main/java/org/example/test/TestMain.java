package org.example.test;


import org.example.fileNav.fileInfo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;

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
        fileInfo.getFile(e);
        pi.check(e);





    }
}