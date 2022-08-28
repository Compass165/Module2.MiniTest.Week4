package model;


import java.io.Serializable;

public class Order implements Serializable {
    private int days;
    private String typeOfRoom;
    private int price;
    People Guest;

    public Order(int days, String typeOfRoom, int price, People guest) {
        this.days = days;
        this.typeOfRoom = typeOfRoom;
        this.price = price;
        Guest = guest;
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

    public People getGuest() {
        return Guest;
    }

    public void setGuest(People guest) {
        Guest = guest;
    }

    @Override
    public String toString() {
        return "Order{" +
                "days=" + days +
                ", typeOfRoom='" + typeOfRoom + '\'' +
                ", price=" + price +
                ", Guest=" + Guest +
                '}';
    }
}
