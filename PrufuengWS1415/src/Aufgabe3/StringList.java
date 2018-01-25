package Aufgabe3;

public class StringList {
    
    private LinkElement head;
    private LinkElement tail;
    
    public String get() {
        if (head == null)
            return null;
        LinkElement tmp = head;
        head = head.next;
        if (head == null)
            tail = null;
        return tmp.data;
    }
    
    public void put(String data) {
        if (head == null) {
            head = tail = new LinkElement(data, null);
        } else {
            tail.next = new LinkElement(data, null);
            tail = tail.next;
        }
        
    }
    
    public String toString() {
        if (head == null)
            return "";
        String output = "";
        LinkElement runner = head;
        while (runner.next != null) {
            output = output + runner.data + "|";
            runner = runner.next;
        }
        output = output + runner.data;
        return output;
    }
    
    
    
}
