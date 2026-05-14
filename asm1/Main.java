package asm1;
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Bài 1: Book ---");
        Book b1 = new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 50000, true);
        Book b2 = new Book("Lão Hạc", "Nam Cao", 40000, true);
        Book b3 = new Book("Tắt Đèn", "Ngô Tất Tố", 45000, false);

        Book[] books = {b1, b2, b3};
        for (Book b : books) {
            b.applyDiscount(10);
            b.printInfo();
        }

        System.out.println("\n--- Bài 2: Rectangle ---");
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(15, 15);

        Rectangle[] rects = {r1, r2};
        for (Rectangle r : rects) {
            System.out.println("Diện tích: " + r.area() + " | Chu vi: " + r.perimeter() + " | Hình vuông: " + r.isSquare());
        }

        System.out.println("\n--- Bài 3: Circle ---");
        Circle[] circles = new Circle[5];
        circles[0] = new Circle(1.0);
        circles[1] = new Circle(2.5);
        circles[2] = new Circle(3.0);
        circles[3] = new Circle(4.0);
        circles[4] = new Circle(5.0);

        double totalArea = 0;
        for (Circle c : circles) {
            totalArea += c.area();
        }
        System.out.println("Tổng diện tích của 5 hình tròn là: " + totalArea);
    }
}