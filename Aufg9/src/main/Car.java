package main;

public class Car  {
    private float x;
    private boolean motorOn;
    private final float maxSpeed;
    private float speed;
    
    private final float fuelTankCapacity;
    private float fuel;
    
    public Car(float maxSpeed, float fuelTankCapacity) {
        this.maxSpeed = maxSpeed;
        this.fuelTankCapacity = fuelTankCapacity;
    }
    
    public float getX()  {
       return x; 
    }
     
    public float getY()  {
       return 50;
    }
     
//    public void setMotorOn(boolean motorOn) {
//        this.motorOn = motorOn;
//    }
    
    public void startMotor() {
        motorOn = true;
    }

    public void stopMotor() {
        motorOn = false;
    }
    
    public boolean getMotorOn() {
       return motorOn;
    }
     
    public float getFuelTankCapacity() {
       return fuelTankCapacity;
    }
     
    public float getFuel() {
       return fuel;
    }
    
    public void refuel(float fuel) {
        if (fuel <= 0)
            return;
        else if (fuel + this.fuel > fuelTankCapacity)
            this.fuel = fuelTankCapacity;
        else
            this.fuel += fuel;
    }
    
    public float getMaxSpeed() {
       return maxSpeed;
    }
     
    public float getSpeed() {
        return speed;
    }
    
    public void setSpeed(float speed) {
        if (speed <= maxSpeed && speed >= 0 && motorOn) {
            this.speed = speed;
        }
    }
    
    public void tick() {
        
    }
    
    private void updateState() {
        x += x + speed * 
    }
    
 }