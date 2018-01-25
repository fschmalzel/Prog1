package Aufgabe3;

public class LinkElement {
    public LinkElement next;
    public String data;
    
    public LinkElement(String data, LinkElement next) {
        this.next = next;
        this.data = data;
    }
    
}
