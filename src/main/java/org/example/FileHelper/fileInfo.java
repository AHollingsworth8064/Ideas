package org.example.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TimerTask;

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

    /**
     * @return this returns the file where the method it belongs to was called via stack
     */
    public static File getMethodCaller() {
        for(StackTraceElement e : Thread.currentThread().getStackTrace()){
            System.out.println(e);
        }
        System.out.println();

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        BufferedReader reader;
        String classPath;
        for(int i = 1; i < stackTrace.length; i++){
            StackTraceElement tempStack = stackTrace[i];
            File tempFile = new File("");
            String tempUrl = tempFile.getAbsolutePath().replace(tempFile.getName(), "")
                    + "/src/main/java/"
                    + stackTrace[i+1].toString().substring(0, stackTrace[i+1].toString().indexOf(stackTrace[i+1].getMethodName()) - 1).replace(".", "/")
                    + ".java";
            try{
                if(tempStack.getMethodName().equals("getMethodCaller")){
                    tempFile = new File(tempUrl);
                    reader = new BufferedReader(new FileReader(tempFile));
                    System.out.println((reader.lines().toArray())[tempStack.getLineNumber()-1] + "file: " + tempStack.getClassName() +  ", lineNum" + tempStack.getLineNumber());


                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
//        for (StackTraceElement stack : stackTrace) {
//            ;
//            File tempFile = new File("");
//            String tempUrl = tempFile.getAbsolutePath().replace(tempFile.getName(), "")
//                    + "/src/main/java/"
//                    + stack.toString().substring(0, stack.toString().indexOf(stack.getMethodName()) - 1).replace(".", "/")
//                    + ".java";
//
//            try {
//                tempFile = new File(tempUrl);
//                reader = new BufferedReader(new FileReader(tempFile));
//                System.out.println((reader.lines().toArray())[stack.getLineNumber()-1] + "file: " + stack.getClassName() +  ", lineNum" + stack.getLineNumber());
//
//
//
//            } catch (Exception e) {
//                if (!stack.toString().contains("Thread")) {
//                    System.out.println(stack.getLineNumber() + " , " + e);
//
//                }
//            }
//
//        }
        return null;
    }
}



