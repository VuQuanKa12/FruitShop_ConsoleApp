/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Fruit;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class readFile {
     private final static fruitManager fruitmanager = new fruitManager();
     

    
    
    public static boolean luuFile(ArrayList<Fruit> frList, String path){
        try{
        FileOutputStream fox = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fox);
        BufferedWriter bw = new BufferedWriter(osw);
        for(Fruit fr : frList){
            String line = fr.getFruiutID()+":"+fr.getFruitName()+":"+fr.getPrice()+":"+fr.getQuantity()+":"+fr.getOrigin();
           bw.write(line);
        bw.newLine();}
        bw.close();
        osw.close();
        fox.close();
        return true;
    }    catch (FileNotFoundException ex) {
             Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
         }
        return  false;
    }
    
    
    public static void luuFileOrder(Hashtable<String, ArrayList<Order>> od,String path){
     try{
        FileOutputStream fox = new FileOutputStream(path, true);
        OutputStreamWriter osw = new OutputStreamWriter(fox);
        BufferedWriter bw = new BufferedWriter(osw);
        od.forEach((key,value)->{
            try {
                bw.write(key+"\n");
                for (Order order : value) {
                    bw.write(order+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bw.close();
        osw.close();
        fox.close();
    }    catch (FileNotFoundException ex) {
             Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
         }       
    }
 
}
