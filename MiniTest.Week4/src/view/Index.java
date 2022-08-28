package view;
import controller.HotelManager;
import model.People;
import model.Order;
import storage.CSV;

import java.util.*;
public class Index {
    static String pathFile = "E:\\IntelliJ\\Module2.Minitest.Week4\\MiniTest.Week4\\src\\storage\\order.dat";
    static final int DETAIL = 1;
    static final int ADD = 2;
    static final int EDIT = 3;
    static final int REMOVE = 4;
    static final int SORT = 5;
    static final int SEARCHMAX = 6;
    static final int READ = 7;
    static final int WRITE = 8;
    static final int EXIT = 9;
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner1 = new Scanner(System.in);
    static List orderList = new CSV().readFile(pathFile);

    public static void menu() {
        System.out.println("---------Quản lý khách hàng-----------" +
                "\n1. Xem danh sách" +
                "\n2. Thêm mới" +
                "\n3. Cập nhật" +
                "\n4. Xóa " +
                "\n5. Sắp xếp" +
                "\n6. Tìm khách hàng có Order thấp nhất" +
                "\n7. ĐỌc File" +
                "\n8. Ghi file" +
                "\n9. Thoát" +
                "\nChọn chức năng:");
    }
    public static void detail(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index:" + i + " " + list.get(i));
        }
    }
    public static void main(String[] args) {
        detail(new CSV().readFile(pathFile));
        menu();
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case DETAIL:
                    detail(orderList);
                    break;
                case ADD:
                    add(orderList);
                    menu();
                    break;
                case EDIT:
                    edit(orderList);
                    break;
                case REMOVE:
                    remove(orderList);
                    break;
                case SORT:
                    sort(orderList);
                    break;
                case SEARCHMAX:
                    search(orderList);
                    break;
                case READ:
                    orderList = new CSV().readFile(pathFile);
                    break;
                case WRITE:
                    new CSV().writeFile(orderList, pathFile);
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập lại:");
            }

        }
    }
    private static void sort(List<Order> list) {
        list.sort(Comparator.comparingDouble(Order::getPrice));
        detail(list);
    }
    private static void search(List<Order> list) {
        System.out.println("Mời nhập Tên khách hàng: ");
        String id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getGuest().getFullName())) {
                System.out.println("Tìm thấy :" + list.get(i).getGuest());
            }
        }
    }

    private static void add(List listPeople, List listOrder) {
        try {
            System.out.println("Mời nhập tên khách hàng: ");
            String fullName = scanner1.nextLine();
            System.out.println("Mời nhập năm sinh khách hàng: ");
            int yearOfBirth = scanner1.nextInt();
            System.out.println("Mời nhập số CMND khách hàng: ");
            int idCard = scanner1.nextInt();
            new HotelManager().add(listPeople, new People(fullName, yearOfBirth, idCard));

            System.out.println("Mời nhập số ngày ở: ");
            int days = scanner1.nextInt();
            System.out.println("Mời nhập hạng phòng: ");
            String typeOfRoom = scanner1.nextLine();
            System.out.println("Mời nhập giá phòng: ");
            int price = scanner1.nextInt();

            new HotelManager().add(listOrder, new Order(days, typeOfRoom, price, new People(fullName, yearOfBirth, idCard)));
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai kiểu dữ liệu:");
        }
    }

    private static void edit(List listPeople, List listOrder) {
        try {
            System.out.println("Mời nhập index khách hàng cần sửa: ");
            int index = scanner.nextInt();
            System.out.println("Mời nhập tên khách hàng: ");
            String fullName = scanner1.nextLine();
            System.out.println("Mời nhập năm sinh khách hàng: ");
            int yearOfBirth = scanner1.nextInt();
            System.out.println("Mời nhập số CMND khách hàng: ");
            int idCard = scanner1.nextInt();
            new HotelManager().edit(listPeople, new People(fullName, yearOfBirth, idCard));

            System.out.println("Mời nhập số ngày ở: ");
            int days = scanner1.nextInt();
            System.out.println("Mời nhập hạng phòng: ");
            String typeOfRoom = scanner1.nextLine();
            System.out.println("Mời nhập giá phòng: ");
            int price = scanner1.nextInt();
        }
    }

}
