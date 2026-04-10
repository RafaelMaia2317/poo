import java.util.Locale;
import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double annualInterestRate = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(initialBalance);
        SavingsAccount.setAnnualInterestRate(annualInterestRate / 100.0);

        System.out.printf(Locale.US, "%nSaldos com taxa de juros de %.1f%%%n", annualInterestRate);

        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf(Locale.US, "Mês %d: R$%.2f%n", month, account.getSavingsBalance());
        }

        System.out.print("%nInforme a nova taxa de juros anual: ");
        double newAnnualInterestRate = scanner.nextDouble();

        System.out.printf(Locale.US, "%nAlterando taxa de juros anual para %.1f%%%n%n", newAnnualInterestRate);

        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate / 100.0);
        account.calculateMonthlyInterest();

        System.out.printf(Locale.US, "Mês 13: R$%.2f%n", account.getSavingsBalance());

        scanner.close();
    }
}
