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
public class Order {
    private String fruitID;
    private String fruitName;
    private int Quantity;
    private Double Price;
    public Order(){}

    public Order(String fruitID, String fruitName, int Quantity, Double Price) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Order{" + "fruitID=" + fruitID + ", fruitName=" + fruitName + ", Quantity=" + Quantity + ", Price=" + Price + '}';
    }


}
