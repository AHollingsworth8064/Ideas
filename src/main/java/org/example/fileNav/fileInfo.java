package org.example.fileNav;

import jdk.jfr.StackTrace;

import java.io.File;

public class fileInfo {
    private static final String locationOfTheProject;
    static{
        try{
            File tempFile = new File("");
            locationOfTheProject = tempFile.getAbsolutePath().replace(tempFile.getName(), "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static File getFile(Object object){
        StackTraceElement[] thing = Thread.currentThread().getStackTrace();
        StackTraceElement stack;
        for(StackTraceElement e: thing){
            System.out.println(e);
        }

//        for(int i = 0; i < thing.length;i++){
//            if(object.getClass().getName().equals(thing[i].getClass()) && );
//        }
//        String processedLocalUrl =  + stack.toString().substring(0, stack.toString().indexOf(stack.getMethodName())-1).replace(".","/")
//                +".java";


        return new File("no");
    }

}
