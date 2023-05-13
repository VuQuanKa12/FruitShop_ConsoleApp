/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import control.Validation;
import control.fruitManager;
import model.Fruit;
import model.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private final static fruitManager fruitmanager = new fruitManager();
     private static final String FILENAME = "FruitShop.txt";
    private final static String[]menuChoice={   "Create Fruit",
                                                "View orders",
                                                "Shopping (for buyer)",
                                                "Exit"};
    
    private static int inputchoice(){
        String st = sc.nextLine().trim();
        if(!Validation.checkPosi_Number(st)) return -1;
        
        int ret =Integer.parseInt(st);
        return ret;
    }
    private static int choice(int menuLength){
        int r;
        boolean posInt;
        do{
            posInt = true;
            System.out.println();
            System.out.print("Enter your choice :  ");
            r = inputchoice();
            if(r>menuLength || r<0){
                System.out.println("Try again!");
                posInt = false;
            }
        }while(!posInt);
             return r;  
    }
    public static void run(){
        String Out ="n";
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        int choice;
        do{
            for (int i=0; i<menuChoice.length; i++){
                System.out.printf("|  %d  |   %s\n",i+1,menuChoice[i]);
            }
          choice = choice(menuChoice.length);  
          
          switch (choice) {
                case 1:
                   fruitmanager.createFruit(fruitmanager.getList());
                    break;
                case 2:
                    fruitmanager.viewOrder(ht);
                    break;
                case 3:
                    fruitmanager.shopping(fruitmanager.getList(), ht);
                    break;
                case 4:
                    System.err.println("DO you Wanna Exist?");
                    System.out.print("Enter your choice : ");
                    do{
                    Out = Validation.inputString().toLowerCase();
                    if(Out.equals("y")){
                        System.exit(0);
                    }
                    if(!Validation.checkYN(Out)){
                        System.err.println("WRong!, Only Yy-Nn!");
                        System.out.print("Enter again: ");
                    }
                    }while(!Validation.checkYN(Out));
              
          }
    }while(Out.equals("n"));

}
     public static void readFile(){
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader buff = null;
         try{
             fis = new FileInputStream("FruitShop.txt");
             
             reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
             
             buff = new BufferedReader(reader);
             String line = null;
             
             while ((line = buff.readLine())!= null){
                 if(line.isEmpty()){
                     continue;
                 }
                 
                 Fruit fr = new Fruit();
                 fr.parse(line);
                 fruitmanager.getList().add(fr);
             }
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             if(fis!=null){
                 try {
                     fis.close();
                 } catch (IOException ex) {
                     Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             if(reader!=null){
                 try {
                     reader.close();
                 } catch (IOException ex) {
                     Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             if(buff!= null){
                 try {
                     buff.close();
                 } catch (IOException ex) {
                     Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
         }
        }

}
//    public static void test(){
//                fruitmanager.getList().add(new Fruit("ds12", "Dua Hau", 9.0, 90, "Quang Binh"));
//                fruitmanager.getList().add(new Fruit("du22", "Dua Luoi", 5.0, 90, "Quang Binh"));
//                fruitmanager.getList().add(new Fruit("ds12", "Tao Tau", 12.0, 90, "Quang Binh"));
//                fruitmanager.getList().add(new Fruit("ds12", "Dao Tien", 9.0, 90, "Quang Binh"));
//                fruitmanager.getList().add(new Fruit("ds12", "Oi Thai", 10.0, 90, "Quang Binh"));
//                
//                
//}


