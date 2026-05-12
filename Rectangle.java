public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

    public void showInfo() {
        System.out.println(
                "Hình chữ nhật: Chiều rộng: " + width + " | Chiều cao: " + height + " | Diện tích: " + area() + " | Chu vi: " + perimeter()
        );
    }
}
