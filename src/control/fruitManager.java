/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Fruit;
import model.Order;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class fruitManager {
    private static final Scanner sc = new Scanner(System.in);
   private  ArrayList<Fruit> fruit = new ArrayList<>();
   public static ArrayList<Order> orders = new ArrayList<>();
    
    public ArrayList<Fruit> getList(){
        return fruit;
    }
    
    public static void createFruit(ArrayList<Fruit> fr){
        String id=null,name=null,origin=null,yn=null;
        int quatity = 0;
        double price;
        do{
            System.out.print("Enter ID Fruit (EX: DH12): ");
            do{
            
            id = Validation.checkInputString();
            if(!Validation.checkID(id)){
                System.err.println("Wrong!,Try again");
                System.out.print("Enter again:  ");
            }
            if(!Validation.checkIDExist(fr, id)){
                System.err.println("ID is really Exist!");
                System.out.print("Enter again: ");
            }
        }while(!Validation.checkID(id)|| !Validation.checkIDExist(fr, id));
            System.out.print("Enter Fruit Name : ");
            do{
                
                name = Validation.checkInputString();
                while(!Validation.checkString(name)){
                    System.err.println("WRONG,Try again");
                    System.out.print("Enter again: ");
                    name = Validation.checkInputString();
                }
                name = Validation.toolName(name);
            }while(!Validation.checkString(name));
            
            
                System.out.print("Enter Price : ");
                price =Validation.checkPrice();
                
                    System.out.print("Enter Quanlity: ");
                    quatity = Validation.checkQuantity();
                do{
                    System.out.print("Enter origin: ");
                
                origin = Validation.checkInputString();
                if(!Validation.checkString(origin)){
                    System.err.println("Wrong!,Try again.");
                }
                origin =Validation.toolName(origin);
                }while(!Validation.checkString(origin));
                


                fr.add(new Fruit(id, name, price, quatity, origin));
                readFile.luuFile(fr, "FruitShop.txt");
                System.out.println("Do you wanna Continue: (yY or nN:)");
                System.out.print("Your choice is : ");
                do{
                yn = Validation.checkInputString().toLowerCase();
                if(!Validation.checkYN(yn)){
                    System.err.println("Only enter y/Y or n/N");
                    System.out.print("Enter again: ");
                }
                }while(!Validation.checkYN(yn));
    }while(yn.equals("y"));

    }
    

    

    public static void displayfruit(ArrayList<Fruit> fr){
        
        if(fr.isEmpty()){
            System.err.println("iS EMPTY!");
            return;
        }
        
        System.out.format("%-3s|  %-13s|   %-8s  |  %-9s |   %-15s %n", "STT"," Namefruit","Quantity","Price","Origin");
        int d=1;
           for (int i=0; i<fr.size(); i++){
               Fruit fruit = fr.get(i);
//               printFruit(fruit);int d=1;
         System.out.format("%-3d|   %-12s|      %-6d | %-6.3f₫   |   %-16s %n", d++,fruit.getFruitName(),fruit.getQuantity(),fruit.getPrice(),fruit.getOrigin());

           }
        
    }
    
    public static void viewOrder(Hashtable<String, ArrayList<Order>> ht){
        if(ht.isEmpty()){
            System.err.println("IS EMPTY!");
            return;
        }else{
            
//        for(String name : ht.keySet()){
//            System.out.println("Customer: "+name);
//            ArrayList<Order> f = ht.get(name);
//            displayListOrder(f);
//            }
//        }
for (String name : ht.keySet()){
    System.out.println("Customer : "+ name);
    ArrayList<Order> f = ht.get(name);
    displayListOrder(f);
}
    }
    }
    public static void displayListOrder(ArrayList<Order> or){
        double amount =0,total =0;
        
        
        if(or.isEmpty()){
            System.err.println("IS EMPTY!");
            return;
        }
        System.out.format("%-12s|  %-9s|  %-9s|  %-6s %n", "Product","Price","quantity","Amount");
        for (Order order : or) {
            System.out.format("%-12s|  %-5.3f₫   |     %-6d|  %-6.3f₫ %n", order.getFruitName(),order.getPrice(),order.getQuantity(),
                                                            amount= order.getPrice()*order.getQuantity());
            total += amount;
        }
        
        System.out.printf("Total : %.3f%s",total,"₫");
        System.out.println();
    }
    
    public static void shopping(ArrayList<Fruit> fr, Hashtable<String, ArrayList<Order>> or){
        String yn,name,ch;
        int t =0;
        int item;
        if(fr.isEmpty()){
            System.err.println("IS EMPTY!");
            return;
        }
        ArrayList<Order> lo = new ArrayList<>();
        do{
            displayfruit(fr);
            do{
            System.out.print("Enter Item: ");
             item = Validation.checkIntLimit(1, fr.size());
             
             
             if(fr.get(item-1).getQuantity()==0){
                System.err.println("mat hang hien tai da het!");
                System.err.println(" continue Shopping?");
                System.out.print("Your choice is : ");
                do{
                ch = Validation.checkInputString().toLowerCase();
                if(!Validation.checkYN(ch)){
                    System.out.println("Only y/Y - n/N");
                    System.out.print("Enter again: "); 
                }
                }while(!Validation.checkYN(ch));
                if(ch.equals("n")) return;
                 }
             
            }while(fr.get(item-1).getQuantity()==0 );
            
            System.out.println("You selected: "+fr.get(item-1).getFruitName());
            
            System.out.print("Enter quantity: ");
            
            int quantity = Validation.checkIntLimit(0, fr.get(item-1).getQuantity());
            
            fr.get(item-1).setQuantity(fr.get(item-1).getQuantity()-quantity);
            
            for (Order order : lo) {
                if(order.getFruitID().equals(fr.get(item-1).getFruiutID())){
                    order.setQuantity(order.getQuantity() + quantity);
                    readFile.luuFile(fr, "FruitShop.txt");
                    t =1;
                }
            }
            if(t == 0){

           lo.add(new Order(fr.get(item-1).getFruiutID(), fr.get(item-1).getFruitName(), quantity, fr.get(item-1).getPrice()));
           readFile.luuFile(fr, "FruitShop.txt");
            }
            t =0;
        System.out.println("Do you wanna Continue: (yY or nN:)");
                System.out.print("Your choice is : ");
                do{
                yn = Validation.checkInputString().toLowerCase();
                if(!Validation.checkYN(yn)){
                    System.err.println("Only enter y/Y or n/N");
                    System.out.print("Enter again: ");
                }
                }while(!Validation.checkYN(yn));
    }while(yn.equals("y"));
          displayListOrder(lo);
          System.out.print("Enter your name: ");
          do{
           name = Validation.checkInputString();
          if(!Validation.checkString(name)){
              System.err.println("Wrong!,Try again!");
              System.out.print("enter again: ");
        }
          name =Validation.toolName(name);
          }while(!Validation.checkString(name));
          or.put(name, lo) ;
          readFile.luuFileOrder(or, "FruitOrder.txt");
          System.out.println("Add successful!");
    }   

    
//    public static void main(String[] args) {
//        ArrayList<Fruit> lf = new ArrayList<>();
//        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
//     while (true) {
//            System.out.println("choice ");
//            int choice = sc.nextInt();
//            switch (choice) {
//                case 1:
//                 createFruit();
//                    break;
//                case 2:
//                 viewOrder(ht);
//                    break;
//               
//                case 4:
//                    return;
//            }
//    }
//}
  
}
