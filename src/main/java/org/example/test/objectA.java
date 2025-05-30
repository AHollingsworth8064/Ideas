package org.example.test;



import java.io.File;
import java.net.URL;
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
       for(StackTraceElement stack: thing){
           URL classPath = (b.getClass().getClassLoader().getResource(stack.getClassName()));
           try {

               assert classPath != null;
               reader = new Scanner(new File(classPath.toURI()));
               System.out.println(reader.skip(String.valueOf(stack.getLineNumber())));
           } catch (Exception e) {
              System.out.println(stack.getLineNumber());
              System.out.println(e);
              System.out.println(classPath);
           }


       }


        return false;
   }
}
