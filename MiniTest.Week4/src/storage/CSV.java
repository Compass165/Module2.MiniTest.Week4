package storage;
import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class CSV {
    public void writeFile(List list, String pathFile) {
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            for (Object x: list) {
//                System.out.println(x);
//            }
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


        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Viet Cong 666", 1998, 111111, 2, "VIP", 5000));
        orderList.add(new Order("Luon", 1998, 222222, 4, "WC", 500));
        orderList.add(new Order("Hokage", 1999, 333333, 10, "VIP", 5000));
        orderList.add(new Order("Shinobi", 1999, 444444, 3, "NORMAL", 2000));
        orderList.add(new Order("Cha xu", 1996, 555555, 6, "VIP", 5000));


        csv.writeFile(orderList,"E:\\IntelliJ\\Module2.Minitest.Week4\\MiniTest.Week4\\src\\storage\\order.dat");
        List<Order> list = csv.readFile("E:\\IntelliJ\\Module2.Minitest.Week4\\MiniTest.Week4\\src\\storage\\order.dat");
        System.out.println(list);
    }


}
