/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Searchanddisplay;

/**
 *
 * @author krishtiwari
 */
public class House {

    public House(String ownername, String contact, double price, String location, String state) {
        this.ownername = ownername;
        this.contact = contact;
        this.price = price;
        this.location = location;
        this.state = state;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

   
    private String ownername;
    private String contact;
    private double price;
    private String location;
    private String state;
  
   
    
}
