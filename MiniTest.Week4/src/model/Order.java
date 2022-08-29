package model;


import java.io.Serializable;

public class Order extends People implements Serializable {
    private int days;
    private String typeOfRoom;
    private int price;


    public Order(String fullName, int yearOfBirth, int idCard, int days, String typeOfRoom, int price) {
        super(fullName, yearOfBirth, idCard);
        this.days = days;
        this.typeOfRoom = typeOfRoom;
        this.price = price;
    }


    public Order() {
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Order{" +
                " name= " +getFullName() +
                " days= " + days +
                ", typeOfRoom='" + typeOfRoom + '\'' +
                ", price=" + price +
                " }";
    }
}
