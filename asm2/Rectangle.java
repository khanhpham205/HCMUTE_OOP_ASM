package asm2;

public class Rectangle {
    private double width;
    private double height;


    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(Rectangle copy) {
        this.width = copy.width;
        this.height = copy.height;
    }




    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }    

    public void scale(double factor) {
        this.width *= factor;
        this.height *= factor;
    }


    // Suy nghĩ: tại sao không thể có 2 constructor cùng nhận 1 tham số double? Hãy thử và 
    // giải thích lỗi

    // Nếu có 2 constructor cùng nhận 1 tham số double, Java sẽ không biết nên gọi constructor nào. 
    // Điều này sẽ dẫn đến lỗi biên dịch vì Java không thể phân biệt giữa hai constructor có cùng kiểu tham số.

}
