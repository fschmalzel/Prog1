package main;

public class CarTest  {  
    public static void main(String[] args) { 
        Car car = Car.buildCar(80, 30);  
        Traffic traffic = new Traffic(car);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        // put your code for car state manipulation here
    } 
}