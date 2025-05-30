package org.example.fileNav;

import jdk.jfr.StackTrace;

import java.io.File;

public class fileInfo {
    public static File getFile(Object object){
        StackTraceElement[] thing = Thread.currentThread().getStackTrace();



        return new File("no");
    }
}
