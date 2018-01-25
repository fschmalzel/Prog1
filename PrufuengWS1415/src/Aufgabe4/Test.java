package Aufgabe4;

// Teilaufgabe c)
public class Test {
    
    public static void main(String[] args) {
        Item food = new Item("Burger", 450);
        Item drink = new Item("Wasser", 100);
        Item[] items = new Item[2];
        items[0] = food;
        items[1] = drink;
        Order bestellung = new Order(items, Order.LOCATIONS.IN_HOUSE);
        System.out.println("Preis: " + bestellung.calcPrice()/100d);
        System.out.println("Stornierung erfolgreich: " + bestellung.cancel());
    }
    
}
