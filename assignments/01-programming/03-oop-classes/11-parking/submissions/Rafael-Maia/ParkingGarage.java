import java.util.Locale;
import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        double charge = 2.0;

        if (hours > 3.0) {
            charge += Math.ceil(hours - 3.0) * 0.5;
        }

        return Math.min(charge, 10.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double total = 0.0;
        int customer = 1;

        System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
        double hours = scanner.nextDouble();

        while (hours != -1.0) {
            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf(Locale.US, "Cliente %d: Taxa de estacionamento: $%.2f%n", customer, charge);
            customer++;

            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = scanner.nextDouble();
        }

        System.out.printf(Locale.US, "Total arrecadado ontem: $%.2f%n", total);
    }
}
