package storage;
import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.People;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class CSV {
    public void writeFile(List list, String pathFile) {
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List readFile(String pathFile) {
        try {
            FileInputStream fis = new FileInputStream(pathFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object ob = ois.readObject();
            List list = (List) ob;
            fis.close();
            ois.close();
            return list;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CSV csv = new CSV();
//        List<People> peopleList = new ArrayList<>();
//        peopleList.add(new People("Banh",1998,111111));
//        peopleList.add(new People("Phong",1999,222222));
//        peopleList.add(new People("Luong",1998,333333));
//        peopleList.add(new People("Huy",1999,444444));
//        peopleList.add(new People("Hang",1991,555555));
        People p1 = new People("Banh",1998,111111);
        People p2 = new People("Phong",1999,222222);
        People p3 = new People("Luong",1998,333333);
        People p4 = new People("Huy",1999,444444);
        People p5 = new People("Hang",1991,555555);

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(3,"Vip",5000,p1));
        orderList.add(new Order(4,"Vip",5000,p2));
        orderList.add(new Order(10,"Normal",2500,p3));
        orderList.add(new Order(1,"Normal",2500,p4));
        orderList.add(new Order(2,"Vip",5000,p5));

        csv.writeFile(orderList,"E:\\IntelliJ\\Module2.Minitest.Week4\\MiniTest.Week4\\src\\storage\\order.dat");
        List<Order> list = csv.readFile("E:\\IntelliJ\\Module2.Minitest.Week4\\MiniTest.Week4\\src\\storage\\order.dat");
        System.out.println(list);
    }


}
