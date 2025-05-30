package org.example.test;


import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
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
       Scanner reader;
       String classPath;
       for(StackTraceElement stack: thing){;
            System.out.println(stack);
           try {

               File tempFile = new File("/" + stack.toString().replace(".","/")+".class");
               System.out.println(tempFile);
               System.out.println(tempFile.exists());
               System.out.println(tempFile.getAbsolutePath());
               reader = new Scanner(tempFile);
           } catch (Exception e) {
              //System.out.println(stack.getLineNumber());
//              System.out.println(e);
              //System.out.println(classPath);
           }


       }


        return false;
   }
}
