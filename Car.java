
public class Car {

    private String licensePlate;
    private String color;
    private int speed;

    public Car(
        String licensePlate,
        String color
    ) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.speed = 0;
    }

    public void accelerate(int delta) {
        speed += delta;
        System.out.println(licensePlate + " tăng tốc lên " + speed + " km/h");
    }

    public void brake(int delta) {
        speed = Math.max(0, speed - delta);
        System.out.println(licensePlate + " giảm tốc còn " + speed + " km/h");
    }

    public void showInfo(int delta) {
        System.out.println(
                "Xe " + licensePlate + " | Màu: " + color + " | Tốc độ: " + speed + " km/h"
        );
    }
}
