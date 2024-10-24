package FourthLab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Введите операцию (add, subtract, multiply, divide) и два числа:");
        String operation = scanner.next();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        try {
            double result = calculator.performOperation(operation, a, b);
            System.out.println("Результат: " + result);
        } catch (CustomUnsupportedOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
