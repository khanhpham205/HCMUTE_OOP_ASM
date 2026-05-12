public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
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

    public void showInfo() {
        System.out.println(
                "Hình chữ nhật: Chiều rộng: " + width + " | Chiều cao: " + height + " | Diện tích: " + getArea() + " | Chu vi: " + getPerimeter()
        );
    }
}
