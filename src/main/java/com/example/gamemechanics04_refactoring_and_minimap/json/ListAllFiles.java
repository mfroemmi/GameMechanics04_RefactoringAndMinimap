package com.example.gamemechanics04_refactoring_and_minimap.json;

import java.io.File;

public class ListAllFiles {
    
    public static String dirPath = "src/main/java/com/example/gamemechanics04_refactoring_and_minimap/save";
    public static File[] fList;
    
    public static void list(String path){
        
        try{
            File directory = new File(path);
            System.out.println(directory);
            fList = directory.listFiles();
            System.out.println(fList);
        }catch(Exception e){

        }
    }
}
