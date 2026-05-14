package asm2.Model;

import asm2.Util.ProductValidator;

public class Product {
    private String productCode; //"P-XXXX"
    private String name;
    private double price;
    private int quantity;
    
    static int counter = 1;
    static int totalProducts = 0;
    static double totalRevenue = 0;

    public Product() {
        // ko cần validate
        this.productCode = "P-" + String.format("%04d", counter++);
        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;

        totalProducts++;
    }
    public Product(String name, double price) {
        String validatedName = ProductValidator.isValidName(name) ? name : "Unknown";
        double validatedPrice = ProductValidator.isValidPrice(price) ? price : 0;

        this.productCode = "P-" + String.format("%04d", counter++);
        this.name = validatedName;
        this.price = validatedPrice;
        this.quantity = 0;

        totalProducts++;
    }
    public Product(String name, double price, int quantity) {
        String validatedName = ProductValidator.isValidName(name) ? name : "Unknown";
        double validatedPrice = ProductValidator.isValidPrice(price) ? price : 0;
        int validatedQuantity = ProductValidator.isValidQuantity(quantity) ? quantity : 0;

        this.productCode = "P-" + String.format("%04d", counter++);
        this.name = validatedName;
        this.price = validatedPrice;
        this.quantity = validatedQuantity;

        totalProducts++;
    }


    public String getProductCode() {
        return productCode;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên sản phẩm không hợp lệ.");
            return;
        }
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Giá sản phẩm không hợp lệ.");
            return;
        }
        this.price = price;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Số lượng sản phẩm không hợp lệ.");
            return;
        }
        this.quantity = quantity;
    }

    public void sell(int amount) {
        if (!(amount > 0)) {
            System.out.println("Số lượng bán ra phải lớn hơn 0.");
            return;
        }
        if (amount > quantity) {
            System.out.println("Không đủ hàng để bán.");
            return;
        }
        quantity -= amount;
        totalRevenue += price * amount;
    }

    public int restock(int amount) {
        if (!(amount > 0)) {
            System.out.println("Số lượng nhập vào phải lớn hơn 0.");
            return totalProducts;
        }
        quantity += amount;
        return totalProducts;
    }


    public void displayInfo() {
        System.out.println("==============================");
        System.out.println("Mã sản phẩm: " + productCode);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Giá sản phẩm: " + price);
        System.out.println("Số lượng tồn kho: " + quantity);
    }

    public static int getTotalProducts() {
        return totalProducts;
    }
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    public static void getStoreReport() {
        System.out.println("==============Báo cáo cửa hàng==============");
        System.out.println("Tổng số sản phẩm: " + getTotalProducts());
        System.out.println("Tổng doanh thu: " + getTotalRevenue());
    }

}
