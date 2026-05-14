package asm2;
import asm2.Model.Product;

public class Main {
    public static void main(String[] args) {


        // bài 1 
        System.out.println("=====================================");
        
        Book book1 = new Book();
        Book book2 = new Book(
            "Dế Mèn Phiêu Lưu Ký", 
            "Tô Hoài", 
            1941, 
            50000
        );
        Book book3 = new Book(
            "Truyện Kiều", 
            "Nguyễn Du"
        );

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book3.applyDiscount(20.9);

        // bài 2
        System.out.println("=====================================");
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(5.0);
        Rectangle rect3 = new Rectangle(3.0, 4.0);

        System.out.println(
            "hình 1 - diện tích : " + rect1.getArea() + ", "+
            "chu vi: " + rect1.getPerimeter() + ", "+
            "là hình vuông: " + rect1.isSquare()
        );
        System.out.println(
            "hình 2 - diện tích : " + rect2.getArea() + ", "+
            "chu vi: " + rect2.getPerimeter() + ", "+
            "là hình vuông: " + rect2.isSquare()
        );
        System.out.println(
            "hình 3 - diện tích : " + rect3.getArea() + ", "+
            "chu vi: " + rect3.getPerimeter() + ", "+
            "là hình vuông: " + rect3.isSquare()
        );

        
        // bài 3
        System.out.println("=====================================");
        BankAccount acc1 = new BankAccount(
            "123456781234", 
            "Nguyen Van A", 
            5000000
        );

        acc1.displayInfo();

        acc1.cashIn(1000000);
        acc1.CashOut(2000000);

        acc1.CashOut(9999999);
        acc1.cashIn(-500);

        // Tạo tài khoản với số dư âm
        BankAccount acc2 = new BankAccount("987654329876", "Tran Thi B", -100);
        acc2.displayInfo();

        // Thay đổi tên chủ tài khoản
        acc1.setOwnerName("Nguyen Van An");
        acc1.displayInfo();

        // Đặt tên chủ tài khoản không hợp lệ
        acc1.setOwnerName("   ");

        // chuyển tền 
        acc1.transfer(acc2, 500000);
        acc1.displayInfo();
        acc2.displayInfo();

        // chuyển quá số dư
        acc1.transfer(acc2, 99999999);

        // Tại sao số tài khoản không nên có setter?
        // Số tài khoản là mã định danh duy nhất cho mỗi tài khoản ngân hàng. (giống với số cccd)
        // Nếu có setter cho số tài khoản, người dùng có thể thay đổi số tài khoản sau khi đã tạo tài khoản
        // Dẫn đến sự nhầm lẫn và mất mát dữ liệu.

        // bài 4
        System.out.println("=====================================");
        Employee em1 = new Employee("Nguyen Van A", 5000000);
        Employee em2 = new Employee("Tran Thi B", 6000000);
        Employee em3 = new Employee("Le Van C", 7000000);


        System.out.println("id nv 1: " + em1.getId());   
        System.out.println("id nv 2: " + em2.getId());   
        System.out.println("id nv 3: " + em3.getId()); 

        System.out.println("Tổng nhân viên: " + Employee.getEmployeeCount());   
        System.out.println("Tổng lương: " + Employee.getTotalSalary());
        System.out.println("Lương trung bình: " + Employee.getAverageSalary());


        em2.setSalary(25000);
        System.out.println("Tổng lương sau khi cập nhật: " + Employee.getTotalSalary());

        // Suy nghĩ và trả lời bằng comment: nếu trong main ta không tạo object nào, gọi 
        // Employee.getAverageSalary() có chạy được không? Tại sao?

        // được 
        // vì getAverageSalary là phương thức static thuộc về lớp Employee, chứ không thuộc về đối tượng nào


        // bài 5
        System.out.println("=====================================");
        Product prod1 = new Product();
        Product prod2 = new Product("Sản phẩm 4", 400000);
        Product prod3 = new Product("Sản phẩm 1", 100000, 50);
        Product prod4 = new Product("Sản phẩm 2", 200000, 30);


        prod1.sell(1); // ko đủ số lượng để bán
        prod3.sell(1); // bán 1 sản phẩm
        prod1.restock(10); // nhập 10

        Product.getStoreReport(); // in báo cáo cửa hàng


        Product prod5 = new Product(
            "Sản phẩm 5", 
            100000, 
            -50
        );
        prod5.displayInfo(); // số lượng âm, không hợp lệ => tự đặt về 0
    }

    // Suy nghĩ: nếu một sản phẩm bị “huỷ” (không bán nữa), totalProducts có nên giảm 
    // không? Bạn xử lý thế nào? Hãy thêm phương thức discontinue() và giải thích lựa chọn 

    // không nên giảm (quan điểm cá nhân) (sortdelete)
    // nên thêm trường isDiscontinued để đánh dấu sản phẩm đã bị huỷ.
    // có thể tiếp tục bán lại lúc cần, và khi báo cáo có những doanh số từ sản phẩm cũ không bị thất lạc.
    // nếu cần biết số sản phẩm còn bán có thể thêm trường static activeProductCount đếm số sản phẩm đang bán.

}