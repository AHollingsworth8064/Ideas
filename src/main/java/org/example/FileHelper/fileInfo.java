package org.example.FileHelper;

import org.example.utils.CustomException;
import org.example.utils.Tuple;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileInfo {

    /**
     * @return this returns the file where the method it belongs to was called via stack
     */
    public static File getMethodCaller() throws CustomException {
        for(StackTraceElement e : Thread.currentThread().getStackTrace()){
            System.out.println(e);
        }
        System.out.println();

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        BufferedReader reader;


        for(int i = 1; i < stackTrace.length; i++){
            if(stackTrace[i].getMethodName().equals("getMethodCaller") && stackTrace[i].getClassName().equals(fileInfo.class.getName()) && i+2< stackTrace.length){
                File file = getClassFile(stackTrace[i+2].getClassName());
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String tempString = (String) reader.lines().toArray()[stackTrace[i+2].getLineNumber()];
                    if(tempString.contains(stackTrace[i+1].getClassName()) && tempString.contains(stackTrace[i+2].getClassName())){
                        return file;
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new CustomException("The method was not called another");
//        for(int i = stackTrace.length-1; i > 1; i--){
//            StackTraceElement tempStack = stackTrace[i];
//            File tempFile = new File("");
//            String tempUrl = tempFile.getAbsolutePath().replace(tempFile.getName(), "")
//                    + "/src/main/java/"
//                    + stackTrace[i].toString().substring(0, stackTrace[i].toString().indexOf(stackTrace[i].getMethodName())).replace(".", "/")
//                    + ".java";
//            try{
//                if(tempStack.getMethodName().equals("getMethodCaller")){
//                    tempFile = new File(tempUrl);
//                    reader = new BufferedReader(new FileReader(tempFile));
//                    System.out.println((reader.lines().toArray())[tempStack.getLineNumber()] + "file: " + tempStack.getClassName() +  ", lineNum" + tempStack.getLineNumber());
//;
//
//                }
//            } catch (Exception e) {
//                System.out.println(e.getCause());
//
//            }
//        }
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

    }
    public static File getClassFile(Object obj){


        return new File("3");
    }

    public static File getClassFile(String className) throws CustomException {
        try{
            System.out.println(className);

            Class<?> aClass = Class.forName(className);
//            Object aClass = Class.forName(className).getDeclaredConstructor().getClass();
            return new File(String.valueOf(getClassPath(aClass)));
        }
        catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
            //throw new CustomException("That class does not exist");
        }
        return null;
    }

    public static <T> Path getClassPath(Class<T> type){
        try {
            String className = type.getName();
            System.out.println(className);
            String KFC = className.substring(className.lastIndexOf(".") + 1) + ".java";
            System.out.println(KFC);
            System.out.println(Class.forName(className).getResource(KFC) + " KFC");

//            System.out.println(test + "4");
;

        } catch (Exception e) {
        }

        return Paths.get(String.valueOf(fileInfo.class.getResource("fileInfo.java")));
    }
}



