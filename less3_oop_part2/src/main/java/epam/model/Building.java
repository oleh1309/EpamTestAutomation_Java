package epam.model;

public class Building {
    private String name;
    private int purchase_price;
    private int price_toStay;

    public Building(String name, int purchase_price, int price_toStay) {
        this.name = name;
        this.purchase_price = purchase_price;
        this.price_toStay = price_toStay;
    }
    public Building(String name) {
        this.name = name;
        this.purchase_price = 0;
        this.price_toStay = 0;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public int getPrice_toStay() {
        return price_toStay;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", purchase_price=" + purchase_price +
                ", price_toStay=" + price_toStay +
                '}';
    }
}
