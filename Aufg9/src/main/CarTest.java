package main;

public class CarTest  {
    
    public static void main(String[] args) { 
        Car car = new Car(150, 80, new float[][] {{30, 50, 100, 140},{3, 5, 6.8f, 9}});
        Traffic traffic = new Traffic(car);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        // put your code for car state manipulation here
        car.tick();
    }
    
}