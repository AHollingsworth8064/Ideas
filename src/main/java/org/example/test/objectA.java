package org.example.test;


import org.example.FileHelper.fileInfo;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class objectA{
   private String name;
   private objectB localB;

    public objectA(int num){
        //this.localB = new objectB(2);
   }
   public <T> void test(Class<T> e){
        System.out.println(e.getName());
   }
   public void test(Object obj){
        System.out.println(obj.getClass().getName());
   }
   public boolean check(objectB b){
     System.out.println(
             objectB.class.getResource("objectB.class")
     );
     b.test();
        return false;
   }
}
