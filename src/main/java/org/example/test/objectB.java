package org.example.test;

import org.example.FileHelper.fileInfo;
import org.example.utils.CustomException;

import java.io.File;

public class objectB {
    public int test;
    public static int id;
    private objectA p;



    public void test() {
        try {
            System.out.println(fileInfo.getMethodCaller().getName());
        } catch (CustomException e) {
            System.out.println("failure at e");
        }
    }



}

