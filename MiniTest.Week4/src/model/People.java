package model;

import java.io.Serializable;
import java.util.Scanner;

public class People implements Serializable {

    private String fullName;
    private int yearOfBirth;
    private int idCard;

    public People(String fullName, int yearOfBirth, int idCard) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.idCard = idCard;
    }

    public People(){
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

//    public void inputGuestInformation() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập họ tên khách hàng: ");
//        fullName = scanner.nextLine();
//        System.out.print("Nhập năm sinh: ");
//        yearOfBirth = scanner.nextInt();
//        System.out.print("Nhập số chứng minh nhân dân: ");
//        idCard = scanner.nextInt();
//    }


    @Override
    public String toString() {
        return "People{" +
                "fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", idCard=" + idCard +
                '}';
    }
}
