package asm2;

public class Employee {
    private int id;
    private String name;
    private double salary;


    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    public Employee(String name, double salary) {
        this.id = nextId++;
        this.name = name;
        this.salary = salary;
        employeeCount++;
        totalSalary += salary;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        totalSalary -= this.salary; // trừ lương cux
        this.salary = salary;
        totalSalary += salary; // cộng lương mới
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }
    public static double getAverageSalary() {
        // tránh chia 0
        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }

    public void raiseSalary(double percent) {
        if(percent < 0) {
            System.out.println("Phần trăm tăng lương không hợp lệ.");
            return;
        }
        double increase = this.salary * percent / 100;
        setSalary(this.salary + increase);
    }

}
