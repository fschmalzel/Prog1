package main;

public class Car  {
    private float x, y;
    private boolean motorOn;
    private final float maxSpeed;
    private float speed;
    
    private final float fuelTankCapacity;
    private float fuel;
    private final float[][] fuelEfficiency;
    
    public Car(float maxSpeed, float fuelTankCapacity, float[][] fuelEfficiency) {
        this.maxSpeed = maxSpeed < 0 ? 20 : maxSpeed;
        
        this.fuelTankCapacity = fuelTankCapacity < 0 ? 30 : fuelTankCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }
    
    public float getX()  {
       return x; 
    }
     
    public float getY()  {
       return y;
    }
    
    public void startMotor() {
        motorOn = true;
    }

    public void stopMotor() {
        motorOn = false;
        speed = 0;
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
        updateState();
    }
    
    private void updateState() {
        if (motorOn) {
            x += speed/3.6;
            
            int index = 0;
            float diff = Math.abs(speed - fuelEfficiency[0][0]);
            for (int i = 0; i < fuelEfficiency[0].length; i++) {
                float newDiff = Math.abs(speed - fuelEfficiency[0][i]);
                if (newDiff < diff) {
                    diff = newDiff;
                    index = i;
                }
            }
            
            fuel -= fuelEfficiency[1][index] * speed/100;
            
            if (fuel <= 0) {
                stopMotor();
                fuel = 0;
            }
            
        }
        
    }
    
    public String toString() {
        return "Motor: " + (motorOn ? "an" : "aus") + "\n"
                + ". Geschwindigkeit: " + speed + " km/h von " + maxSpeed + " km/h.\n "
                + "Sprit: " + fuel + " / " + fuelTankCapacity + "Liter.";
        
    }
    
 }