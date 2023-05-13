/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Fruit;
import model.Order;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    public static int checkIntLimit(int min, int max){
        while (true) {            
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result <min || result>max){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException e){
                System.err.println("Wrong!, input in range ["+min+"-"+max+"]");
                System.out.print("Enter Again : ");
            }
        }
    }
    
    public static String checkInputString(){
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Not Empty!");
                System.out.print("Enter again: ");
            }else{
                return result;
            }
        }
    }
  public static boolean checkID(String id){
      Pattern pat = Pattern.compile("^[a-zA-Z]{2}[0-9]{2}+$");
      Matcher mat = pat.matcher(id);
      return mat.matches();
  }
  
  public static boolean checkString(String st){
      Pattern pat = Pattern.compile("^[\\pL\\ ]+$");
      Matcher mat = pat.matcher(st);
      if(!mat.matches()) {return false;}
      
      for (int i=0; i<st.length()-1; i++){
          if(st.charAt(i)==' '&& st.charAt(i+1)==' '){
              return false;
          }
      }
      return true;
  }
  public static String toolName(String name){

      String[] st =name.split(" ");
      StringBuilder ret = new StringBuilder();

      for(int i=0; i<st.length; i++){
          String dau = st[i].substring(0, 1).toUpperCase();
          String sau = st[i].substring(1).toLowerCase();
          st[i]=dau.concat(sau);
          ret.append(st[i]+" ");
      }
      return ret.toString();
  }
  
    public  static int checkQuantity(){
        while (true) {    
            try{
                String fre = checkInputString();
            int result = Integer.parseInt(fre.trim());
             if(result<0||!checkPosi_Number(fre)){
                    System.err.println("Can't <0");
                    System.out.print("Enter again :  ");
                    fre = checkInputString();
                    result = Integer.parseInt(fre.trim());
                }
            return result;
        }catch(NumberFormatException e){
                System.err.println("WRONG!, Try again! ");
                System.out.print("Enter again : ");
            }
        }
    }
    
    
    public static Double checkPrice(){
        double result;
        while (true) {            
            try{
                result = Double.parseDouble(sc.nextLine().trim());
                if(result<=0){
                    System.err.println("Can't <0");
                    System.out.print("Enter again :  ");
                    result = Double.parseDouble(sc.nextLine().trim());
                }
                return result;
            }catch(NumberFormatException e){
                System.err.println("Wrong!,try again!");
                System.out.print("Enter again : ");
            }
        }
    }
        
        public static boolean checkYN(String yn){
           Pattern pat = Pattern.compile("^[yYnN]+$");
           Matcher mat = pat.matcher(yn);
           return mat.matches();
   }

        
        public static boolean checkIDExist(ArrayList<Fruit> fr,String id){
            for(int i=0; i<fr.size(); i++){
                if(fr.get(i).getFruiutID().equals(id))
                    return false;
                }
            
            return true;
        }
        

 public static String inputString(){
     
     while (true) {         
         String choice = sc.nextLine().trim();
         if(choice.isEmpty()){
             System.err.println("Not Empty!");
             System.out.print("Enter again: ");
         }
         else{return choice;}
         
     }
 }
     public static boolean checkPosi_Number(String s){
        Pattern pa = Pattern.compile("^[+]?[0-9]+$");
        Matcher ma = pa.matcher(s);
        boolean b = ma.matches();
        
        try{
            if(!b) return b;
            else Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return b;
    }

//    public static void main(String[] args) {
//        System.out.println("enter price :");
//        Double pri = checkPrice();
//        System.out.println(pri);
//    }
}
