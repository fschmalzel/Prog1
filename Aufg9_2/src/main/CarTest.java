package main;

public class CarTest  {  
    public static void main(String[] args) { 
        Car car = Car.buildCar(80, 30, new float[][] {{30, 50, 100, 140},{3, 5, 6.8f, 9}});
        
        Traffic traffic = new Traffic(car);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        car.refuel(5);
        car.startMotor();
        car.setSpeed(20);

        System.out.println(car.toString());
        
        Traffic.waitAWhile(1_000);
        
        System.out.println(car.toString());

        Traffic.waitAWhile(10_000);

        System.out.println(car.toString());
        
        car.refuel(2);
        car.startMotor();
        car.setSpeed(30);
        Traffic.waitAWhile(1_000);
        car.stopMotor();
        
    } 
}