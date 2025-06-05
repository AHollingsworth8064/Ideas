package org.example.test;


import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class objectA {
   private String name;
   private objectB localB;

    public objectA(int num){
        //this.localB = new objectB(2);
   }
   public void test(objectB e){

   }
   public boolean check(objectB b){
       StackTraceElement[] thing = Thread.currentThread().getStackTrace();
       BufferedReader reader;
       String classPath;
       int l;
       for(StackTraceElement stack: thing){;
            File tempFile = new File("");
            String tempUrl =tempFile.getAbsolutePath().replace(tempFile.getName(), "")
                    + "/src/main/java/"
                    + stack.toString().substring(0, stack.toString().indexOf(stack.getMethodName())-1).replace(".","/")
                    +".java";

            try {
                tempFile = new File(tempUrl);
                tempFile.setReadable(true);
                reader = new BufferedReader(new FileReader(tempFile));
                System.out.println((reader.lines().toArray())[stack.getLineNumber()-1] + "file: " + stack.getClassName() +  ", lineNum" + stack.getLineNumber());

            } catch (Exception e) {
                if(!stack.toString().contains("Thread")){
                    System.out.println(stack.getLineNumber() + " , " + e);
                }
           }


       }


        return false;
   }
   public void wt(Object object){

   }
}
