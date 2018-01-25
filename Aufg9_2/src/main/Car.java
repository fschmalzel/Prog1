package main;
public class Car  {
    private float x;
    private boolean motorOn = false;
    
    private final float maxSpeed;
    private final float maxReverseSpeed;
    private float speed;
    
    private final float fuelTankCapacity;
    private float fuel;
    private final float[][] fuelEfficiency;
    private float currentFuelUsage;
    
    private long lastTimestamp;
    
    private Car(float fuelTankCapacity, float maxSpeed, float reverseMaxSpeed, float[][] fuelEfficiency) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed/3.6f;
        this.maxReverseSpeed = reverseMaxSpeed/3.6f;
        this.fuelEfficiency = fuelEfficiency;
    }
    
    /**
     * Checks all parameters for validity and returns a new {@link Car},
     * if all parameters are valid.
     * 
     * @param fuelTankCapacity The capacity of the fuel tank
     * @param maxSpeed The maximum speed of the car
     * @param reverseMaxSpeed The maximum reverse speed of the car (has to be negative)
     * @param fuelEfficiency a 2 dimensional array describing the fuel economy of the car
     * @return a new Car with the specified parameters
     */
    public static Car buildCar(float fuelTankCapacity, float maxSpeed, float reverseMaxSpeed, float[][] fuelEfficiency) {
        
        // If the maxSpeed is negative or the tankCapacity is negative
        // or the reverseMaxSpeed is positiv then these values are not valid
        if (maxSpeed <= 0 || fuelTankCapacity <= 0 || reverseMaxSpeed > 0)
            return null;
        
        // Copying the fuelEfficiency array to prevent manipulation
        float[][] tempFuelEfficiency = new float[2][];
        for (int i = 0; i < fuelEfficiency.length; i++) {
            tempFuelEfficiency[i] = fuelEfficiency[i].clone();
        }
        
        // Checking if the fuelEfficiency table is valid
        if (!validFuelEfficiency(tempFuelEfficiency))
            return null;
        
        // Everything is right, so we give back the car with the specified parameters
        return new Car(fuelTankCapacity, maxSpeed, reverseMaxSpeed, tempFuelEfficiency);
        
    }
    
    /**
     * Gives back the traveled distance in meters.
     * This function does also update the cars variables.
     * 
     * @return Traveled distance
     */
    public float getX()  {
        updateState();
        return x; 
    }
    
    public float getY()  {
       return 50;
    }
     
    /**
     * @return If the engine is running true, else false
     */
    public boolean getMotorOn() {
       return motorOn;
    }
    
    /**
     * Starts the motor if there is enough fuel in the tank
     */
    public void startMotor() {
        // If there's no fuel, then the engine can't start
        if (fuel > 0) {
            motorOn = true;
        }
    }
    
    /**
     * Stops the motor
     */
    public void stopMotor() {
        // If the engine stops, the current speed is 0 and the currentFuelUsage == 
        motorOn = false;
        speed = 0;
        currentFuelUsage = 0;
    }
    
    /**
     * @return The capacity of the fuel tank
     */
    public float getFuelTankCapacity() {
       return fuelTankCapacity;
    }
     
    /**
     * @return The current amount of fuel in the tank
     */
    public float getFuel() {
       return fuel;
    }
    
    /**
     * Refuels the tank up to the maximum capacity.
     * Negative values do nothing
     * 
     * @param fuel The amount of fuel in liters
     */
    public void refuel(float fuel) {
        // Negative amounts of fuel can't be put into a tank
        if (fuel <= 0)
            return;
        
        // If both combined are greater than the capacity
        // then the tank is just full and the rest goes somewhere
        if (this.fuel + fuel > fuelTankCapacity)
            this.fuel = fuelTankCapacity;
        else
            // Else put the fuel in the tank normally
            this.fuel += fuel;
        
    }
    
    /**
     * @return The maximum speed of the car in m/s
     */
    public float getMaxSpeed() {
        return maxSpeed*3.6f;
    }
    
    /**
     * @return The maximum reverse speed of the car in m/s
     */
    public float getMaxReverseSpeed() {
        return maxReverseSpeed*3.6f;
    }
     
    /**
     * @return The current speed in m/s
     */
    public float getSpeed() {
        return speed*3.6f;
    }
    
    /**
     * Sets the speed of the car, if the engine is running and if the car is capable of the new speed.
     * 
     * @param speed The new speed of the car
     */
    public void setSpeed(float speed) {
        speed /= 3.6f;
        if (motorOn && speed <= maxSpeed && speed >= maxReverseSpeed) {
            // If the car is capable of the speed and the motor is running
            // we can update the speed
            this.speed = speed;
            
            // Since we aren't using acceleration, we do not need to update the
            // currentFuelUsage in every update, just when the speed has been changed
            updateCurrentFuelUsage();
        }
    }
    
    private void updateCurrentFuelUsage() {
        
        // Searching through the array and using the fuelUsage which is closest
        // to the current speed of the car
        int index = 0;
        float diff = Math.abs(speed*3.6f - fuelEfficiency[0][0]);
        for (int i = 0; i < fuelEfficiency[0].length; i++) {
            float newDiff = Math.abs(speed*3.6f - fuelEfficiency[0][i]);
            if (newDiff < diff) {
                diff = newDiff;
                index = i;
            }
        }
        
        currentFuelUsage = fuelEfficiency[1][index];
    }
    /**
     * Let's the car run for 1 second
     */
    public void tick() {
        updateState(1000);
    }
    
    /**
     * Let's the car run for the specified amount of milliSeconds
     * 
     * @param milliSeconds
     */
    private void updateState(long milliSeconds) {
        // Calculating the traveled distance
        double distance = milliSeconds/1000d * speed;
        
        x += distance;
        
        fuel -= currentFuelUsage/100d * distance/1000d;
        
        if (fuel <= 0) {
            fuel = 0;
            stopMotor();
        }
        
    }
    
    /**
     * Lazy update implementation of updateState
     */
    private void updateState() {
        // If there is no lastTimestamp (0) then we need to update it
        if (lastTimestamp == 0) {
            lastTimestamp = System.currentTimeMillis();
        } else {
            // Else we can use the lastTimestamp and the currentTime to
            // update the car for the difference in milliseconds
            long time = System.currentTimeMillis();
            updateState(time - lastTimestamp);
            // And update the lastTimestamp
            lastTimestamp = time;
        } 
    }
    
    /**
     * Checks a fuelEfficiency table for validity
     * 
     * @param fuelEfficiency The 2D array which needs to be checked
     * @return True if valid, else false
     */
    private static boolean validFuelEfficiency(float[][] fuelEfficiency) {
        //There have to be exactly two arrays
        if (fuelEfficiency.length != 2)
            return false;
        
        // The two arrays need to have the same length
        if (fuelEfficiency[0].length != fuelEfficiency[1].length)
            return false;
        
        // The speed could be negative, but the fuelUsage has to be positive
        for (int i = 0; i < fuelEfficiency[1].length; i++) {
            if (fuelEfficiency[1][i] <= 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * @return Returns the current state of the car as a string.
     */
    public String toString() {
        return "Motor: " + (motorOn ? "an" : "aus") + "\n"
                + "Geschwindigkeit: " + speed + " von " + maxSpeed + " m/s\n"
                + "Geschwindigkeit: " + speed*3.6f + " von " + maxSpeed*3.6f + " km/h\n"
                + "Sprit: " + fuel + " / " + fuelTankCapacity + " Liter.\n"
                + "Zurückgelegte Strecke: " + x + " Meter.";
        
    }
    
 }