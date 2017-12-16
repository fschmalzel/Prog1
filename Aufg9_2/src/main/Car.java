package main;
public class Car  {
    private float x;
    private boolean motorOn = false;
    private final float maxSpeed;
    private float speed;
    
    private final float fuelTankCapacity;
    private float fuel;
    private final float[][] fuelEfficiency;
    
    private float currentFuelUsage;
    
    private long lastTimestamp;
    
    private Car(float fuelTankCapacity, float maxSpeed, float[][] fuelEfficiency) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed;
        this.fuelEfficiency = fuelEfficiency;
    }
    
    public static Car buildCar(float fuelTankCapacity, float maxSpeed, float[][] fuelEfficiency) {
        
        if (maxSpeed <= 0 || fuelTankCapacity <= 0)
            return null;
            
        //TODO Check fuelEfficiency
        
        return new Car(fuelTankCapacity, maxSpeed, fuelEfficiency);
        
    }
    
    public float getX()  {
        updateState();
        return x; 
    }
     
    public float getY()  {
       return 50;
    }
     
     
    public boolean getMotorOn() {
       return motorOn;
    }
     
    public void startMotor() {
        if (fuel > 0) {
            motorOn = true;
        }
    }
    
    public void stopMotor() {
        motorOn = false;
        speed = 0;
        currentFuelUsage = 0;
        lastTimestamp = 0;
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
        else if (this.fuel + fuel > fuelTankCapacity)
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
        if (motorOn && speed <= maxSpeed && speed >= 0) {
            this.speed = speed;
            
            int index = 0;
            float diff = Math.abs(speed - fuelEfficiency[0][0]);
            for (int i = 0; i < fuelEfficiency[0].length; i++) {
                float newDiff = Math.abs(speed - fuelEfficiency[0][i]);
                if (newDiff < diff) {
                    diff = newDiff;
                    index = i;
                }
            }
            
            currentFuelUsage = fuelEfficiency[1][index];
            
        }
    }
    
    public void tick() {
        updateState(1000);
        Traffic.waitAWhile(1000);
    }
    
    public void tick(long milliSeconds) {
        updateState(milliSeconds);
        Traffic.waitAWhile(milliSeconds);
    }
    
    private void updateState(long milliSeconds) {
        double distance = milliSeconds/1000d * speed;
        x += distance;
        
        fuel -= currentFuelUsage * distance/100d;
        
        if (fuel <= 0) {
            fuel = 0;
            stopMotor();
        }
        
    }
    
    private void updateState() {
        if (lastTimestamp == 0) {
            lastTimestamp = System.currentTimeMillis();
        } else {
            long time = System.currentTimeMillis();
            updateState(time - lastTimestamp);
            lastTimestamp = time;
        } 
    }
    
    public String toString() {
        return "Motor: " + (motorOn ? "an" : "aus") + "\n"
                + "Geschwindigkeit: " + speed + " von " + maxSpeed + " m/s\n"
                + "Geschwindigkeit: " + speed/3.6f + " von " + maxSpeed/3.6f + " km/h\n"
                + "Sprit: " + fuel + " / " + fuelTankCapacity + " Liter.";
        
    }
    
 }