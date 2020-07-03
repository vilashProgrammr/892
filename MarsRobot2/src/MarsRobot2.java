/* Solution to Chapter 1, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */
class MarsRobot2 {
    String status;
    int speed;
    float temperature;

    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }
    
    public static void main(String[] arguments) {
        MarsRobot2 spirit = new MarsRobot2();
        spirit.status = "exploring";
    
        spirit.speed = 2;
        spirit.temperature = -60;

        System.out.println("\nSpirit:");
        spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Changing temperature to 670.");
        spirit.temperature = 670;
        spirit.showAttributes();
        System.out.println("Checking the temperature.");
        spirit.checkTemperature();
        spirit.showAttributes();

        MarsRobot2 opportunity = new MarsRobot2();
        System.out.println("\nSpirit:");
        opportunity.status = "exploring";
        opportunity.speed = 4;
        opportunity.temperature = -90;
        opportunity.showAttributes();
    }
}