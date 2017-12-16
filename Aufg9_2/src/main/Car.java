package main;
public class Car  {
    private float x;
    private boolean motorOn = false;
    private final float maxSpeed;
    private float speed;
    
    private final float fuelTankCapacity;
    private float fuel;
    
    private Car(float fuelTankCapacity, float maxSpeed) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed;
    }
    
    public static Car buildCar(float fuelTankCapacity, float maxSpeed) {
        
        if (maxSpeed <= 0 || fuelTankCapacity <= 0)
            return null;
            
        return new Car(fuelTankCapacity, maxSpeed);
        
    }
    
    public float getX()  {
       return x; 
    }
     
    public float getY()  {
       return 50;
    }
     
     
    public boolean getMotorOn() {
       return motorOn;
    }
     
    public void startMotor() {
        //TODO: if fuel >0
        motorOn = true;
    }
    
    public void stopMotor() {
        motorOn = false;
        //TODO: speed = 0
    }
    
    public float getFuelTankCapacity() {
       return fuelTankCapacity;
    }
     
    public float getFuel() {
       return fuel;
    }
    
    public void refuel(float fuel) {
        if (fuel > 0) {
            
            if (this.fuel + fuel > fuelTankCapacity)
                this.fuel = fuelTankCapacity;
            else
                this.fuel += fuel;
            
        }
    }
     
    public float getMaxSpeed() {
       return maxSpeed;
    }
     
    public float getSpeed() {
     return speed;
    }
    
    public void setSpeed(float speed) {
        if (motorOn && speed < maxSpeed && speed >= 0) {
            this.speed = speed;
        }
    }
    
    public void tick() {
        updateState();
    }
    
    private void updateState() {
        x += speed * 1;
    }
    
    public String toString() {
        return "Motor: " + (motorOn ? "an" : "aus") + "\n"
                + ". Geschwindigkeit: " + speed + " km/h von " + maxSpeed + " km/h.\n "
                + "Sprit: " + fuel + " / " + fuelTankCapacity + "Liter.";
        
    }
    
 }