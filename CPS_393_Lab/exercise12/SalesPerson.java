package CPS_393_Lab.exercise12;

public class SalesPerson {
    String name;
    String city;
    double commission;
    double totalSales;

    public SalesPerson(String name, String city, double commission, double totalSales) {
        this.name = name;
        this.city = city;
        this.commission = commission;
        this.totalSales = totalSales;

    }

    public String toString() {
        return name + " | " + city + " | " + commission + " | " + totalSales;

    }
}
