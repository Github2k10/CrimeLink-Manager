package com.ui;

public class ColorLogger {
    public void printlnDebug(String logging) {
        System.out.println("\u001B[93m" + logging);
    }
    public void  printlnInfo(String logging) {
    	System.out.println("\u001B[32m" + logging);
    }
    
    public void printlnError(String logging) {
    	System.out.println("\u001B[31m" + logging);
    }
    
    public void printDebug(String logging) {
        System.out.print("\u001B[93m" + logging + "\u001B[93m");
    }
    public void printInfo(String logging) {
    	System.out.print("\u001B[32m" + logging);
    }
    
    public void printError(String logging) {
    	System.out.print("\u001B[31m" + logging);
    }
}
