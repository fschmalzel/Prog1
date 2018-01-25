package Aufgabe4;

// Teilaufgabe a)
public class Item {
    private final String name;
    private final int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
}
