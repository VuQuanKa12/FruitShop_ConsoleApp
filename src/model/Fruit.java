/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Fruit {
    private String fruitID;
    private String fruitName;
    private Double price;
    private int quantity;
    private String origin;
    
    public Fruit(){}

    public Fruit(String fruitID, String fruitName, Double Price, int Quantity, String Origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = Price;
        this.quantity = Quantity;
        this.origin = Origin;
    }

    public String getFruiutID() {
        return fruitID;
    }

    public void setFruiutID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String Origin) {
        this.origin = Origin;
    }
    
public void parse(String line){
    String[] paras = line.split(":");
    fruitID = paras[0];
    fruitName = paras [1];
    price = Double.parseDouble(paras[2]);
    quantity = Integer.parseInt(paras[3]);
    origin = paras[4];
}
    @Override
    public String toString() {
        return "Fruit{" + "fruiutID=" + fruitID + ", fruitName=" + fruitName + ", Price=" + price + ", Quantity=" + quantity + ", Origin=" + origin + '}';
    }
    
    
}
