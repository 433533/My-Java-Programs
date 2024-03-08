import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0); // Base currency
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.72);
        conversionRates.put("JPY", 109.48);
        conversionRates.put("INR", 74.26); // Adding INR to the conversion rates

        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            System.out.println("Enter the amount:");
            double amount = scanner.nextDouble();

            System.out.println("Enter the source currency (e.g., USD, EUR, GBP, INR):");
            String sourceCurrency = scanner.next().toUpperCase();

            System.out.println("Enter the target currency (e.g., USD, EUR, GBP, INR):");
            String targetCurrency = scanner.next().toUpperCase();

            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency, conversionRates);
            if (convertedAmount != -1) {
                System.out.printf("%.2f %s is equal to %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);
            } else {
                System.out.println("Currency conversion is not supported.");
            }

            System.out.println("Do you want to convert another currency? (yes/no)");
            String choice = scanner.next().toLowerCase();
            continueConversion = choice.equals("yes");
        }

        scanner.close();
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency, Map<String, Double> conversionRates) {
        double fromRate = conversionRates.getOrDefault(fromCurrency, -1.0);
        double toRate = conversionRates.getOrDefault(toCurrency, -1.0);

        if (fromRate != -1 && toRate != -1) {
            return (amount / fromRate) * toRate;
        } else {
            return -1;
        }
    }
}
