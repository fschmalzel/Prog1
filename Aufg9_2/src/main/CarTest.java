package main;

import java.io.IOException;

public class CarTest  {  
    public static void main(String[] args) { 
        Car car = Car.buildCar(80, 50, -10, new float[][] {{-10, 30, 50, 100, 140},{1.8f, 3, 5, 6.8f, 9}});
        
        Traffic traffic = new Traffic(car);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        int input = -1;
        
        while (true) {
            
            try {
                input = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            switch(input) {
            case '.':
                car.startMotor();
                break;
            case ',':
                car.stopMotor();
                break;
            case '+':
                car.setSpeed(car.getSpeed() + 1);
                break;
            case '-':
                car.setSpeed(car.getSpeed() - 1);
                break;
            case 'r':
                car.refuel(5);
                break;
            case 's':
                System.out.println(car.toString());
                break;
            }
            
            
        }
        
        
//        car.refuel(5);
//        car.startMotor();
//        car.setSpeed(20);
//
//        System.out.println(car.toString());
//        
//        Traffic.waitAWhile(1_000);
//        
//        System.out.println(car.toString());
//
//        Traffic.waitAWhile(10_000);
//
//        System.out.println(car.toString());
//        
//        car.refuel(2);
//        car.startMotor();
//        car.setSpeed(30);
//        Traffic.waitAWhile(1_000);
//        car.stopMotor();
        
    } 
}