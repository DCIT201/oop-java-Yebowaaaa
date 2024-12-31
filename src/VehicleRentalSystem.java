// VehicleRentalSystem.java
import java.util.Scanner;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RentalAgency rentalAgency = new RentalAgency();
        
        rentalAgency.addVehicle(new Car("V001", "Sedan", 50, true)); 
        rentalAgency.addVehicle(new Motorcycle("V002", "Harley", 30, true)); 

        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter your license number: ");
        String licenseNumber = scanner.nextLine();
        
        Customer customer = new Customer(customerName, licenseNumber);

        System.out.println("\nAvailable vehicles for rent:");
        Vehicle availableVehicle = rentalAgency.findAvailableVehicle();
        if (availableVehicle != null) {
            System.out.println("Vehicle available: " + availableVehicle.getModel());
        } else {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.println("Enter the number of rental days: ");
        int rentalDays = scanner.nextInt();
        
        if (availableVehicle != null) {
            availableVehicle.setAvailability(false); 
            double rentalCost = availableVehicle.calculateRentalCost(rentalDays);
            System.out.println("Vehicle rented to " + customer.getName() + " for " + rentalDays + " days.");
            System.out.println("Total rental cost: $" + rentalCost);
        }

        System.out.println("\nReturning the vehicle...");
        if (availableVehicle != null) {
            availableVehicle.setAvailability(true); 
            System.out.println("Vehicle has been returned.");
        }

        scanner.close();
    }
}
