package Aufgabe4;

// Teilaufgabe b)
public class Order {
    public static enum LOCATIONS {
        TAKE_AWAY, IN_HOUSE
    }
    
    public static enum STATES {
        TAKEN, PAID, IN_PREPARATION,
        DELIVERED, CANCELED
    }
    
    public final LOCATIONS location;
    private STATES state = STATES.TAKEN;
    private final Item[] items;
    
    public Order(Item[] items, LOCATIONS location) {
        this.items = new Item[items.length];
        for (int i = 0; i < items.length; i++) 
            this.items[i] = items[i];
        this.location = location;
    }
    
    public long calcPrice() {
        long total = 0;
        for (Item item : items)
            total += item.getPrice();
        if (location == LOCATIONS.TAKE_AWAY)
            total *= 0.90D;
        return total;
    }
    
    public boolean changeToPaid() {
        if (STATES.TAKEN == state) {
            state = STATES.PAID;
            return true;
        } else
            return false;
    }
    
    public boolean startPreparation() {
        if (STATES.PAID == state) {
            state = STATES.IN_PREPARATION;
            return true;
        } else
            return false;
    }
    
    public boolean cancel() {
        if (state != STATES.TAKEN && state != STATES.PAID)
            return false;
        if (state == STATES.PAID)
            System.out.println("Zurück zu zahlen sind " + calcPrice()/100D + "€");
        state = STATES.CANCELED;
        return true;
    }
    
    public boolean changeToDelivered() {
        if (state == STATES.IN_PREPARATION) {
            state = STATES.DELIVERED;
            return true;
        } else 
            return false;
    }
    
}
