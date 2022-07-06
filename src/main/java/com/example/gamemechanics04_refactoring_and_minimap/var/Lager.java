package com.example.gamemechanics04_refactoring_and_minimap.var;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lager {
    
    public static String[][] lagerArray = {
        {"Holz", ""},
        {"Stein", ""}
    };
    
    public static void laden(String dirPath) {
        File file = new File(dirPath);
        try{
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONObject json = new JSONObject(content);
            
            for (int i = 0; i < lagerArray.length; i++) {
            lagerArray[i][1] = String.valueOf(json.getInt(lagerArray[i][0]));
            }
            
        }catch(Exception e){
            
        }
    }
    
    public static void speichern(String dirPath) {
        try{
            JSONObject json = new JSONObject();
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
            Date date = new Date();        
            String dateToStr = dateFormat.format(date);
            
            json.put("datum", dateToStr);
            
            for (int i = 0; i < lagerArray.length; i++) {
            json.put(lagerArray[i][0], Integer.parseInt(lagerArray[i][1]));
            }
            
            FileWriter fw = new FileWriter(new File("src/main/java/com/example/gamemechanics04_refactoring_and_minimap/save/" + dirPath + ".json"));
            fw.write(json.toString());
            fw.flush();
            fw.close();
            
        }catch(Exception e){
            
        }
    }
    
    public static int getHolz(){
        return Integer.parseInt(lagerArray[0][1]);
    }
    
    public static void setHolz (int holz) {
        lagerArray[0][1] = String.valueOf(holz);
    }
}
