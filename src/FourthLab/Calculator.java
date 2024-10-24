package FourthLab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            CustomUnsupportedOperationException ex = new CustomUnsupportedOperationException("Деление на ноль невозможно.");
            logException(ex);
            throw ex;
        }
        return a / b;
    }

    public double performOperation(String operation, double a, double b) {
        switch (operation.toLowerCase()) {
            case "add":
                return add(a, b);
            case "subtract":
                return subtract(a, b);
            case "multiply":
                return multiply(a, b);
            case "divide":
                return divide(a, b);
            default:

                CustomUnsupportedOperationException ex = new CustomUnsupportedOperationException("Операция \"" + operation + "\" не поддерживается.");
                logException(ex);
                throw ex;
        }
    }
    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/FourthLab/exception_log.txt", true))) {
            writer.write(LocalDateTime.now() + " - " + e.getClass().getSimpleName() + ": " + e.getMessage());
            writer.newLine();
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в лог-файл: " + ioException.getMessage());
        }
    }
}
