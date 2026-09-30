import java.util.Scanner;

public class DigitalWattmeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          DIGITAL WATTMETER");
        System.out.println("====================================");

        System.out.print("Enter voltage (V): ");
        double voltage = sc.nextDouble();

        System.out.print("Enter current (A): ");
        double current = sc.nextDouble();

        System.out.print("Enter power factor (0 to 1): ");
        double powerFactor = sc.nextDouble();

        System.out.print("Enter operating time (hours): ");
        double time = sc.nextDouble();

        // Validation
        if (voltage < 0 || current < 0 ||
            powerFactor < 0 || powerFactor > 1 ||
            time < 0) {

            System.out.println("\nInvalid input!");
            System.out.println("Power factor must be between 0 and 1.");
            sc.close();
            return;
        }

        // Calculate real power
        double power = voltage * current * powerFactor;

        // Calculate apparent power
        double apparentPower = voltage * current;

        // Calculate energy
        double energy = power * time;

        System.out.println("\n------------ RESULTS ------------");
        System.out.printf("Voltage          : %.2f V%n", voltage);
        System.out.printf("Current          : %.2f A%n", current);
        System.out.printf("Power Factor     : %.2f%n", powerFactor);
        System.out.printf("Apparent Power   : %.2f VA%n", apparentPower);
        System.out.printf("Real Power       : %.2f W%n", power);
        System.out.printf("Energy Consumed  : %.2f Wh%n", energy);
        System.out.println("---------------------------------");

        if (power == 0) {
            System.out.println("Load Status: OFF");
        } else if (power < 1000) {
            System.out.println("Load Status: LOW POWER");
        } else {
            System.out.println("Load Status: HIGH POWER");
        }

        System.out.println("=================================");

        sc.close();
    }
}
