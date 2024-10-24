package FourthLab;

public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, 3, 4, 5.9, "qwe"};
        double sum = 0.0;
        boolean errors = false;

        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] instanceof Integer) {
                    sum += (Integer) arr[i];
                } else {
                    sum += (Double) arr[i];
                }
            }
            System.out.println("Среднее: " + (double) sum / arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива"+" - " + e.getMessage());
            errors = true;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль" + " - " + e.getMessage());
            errors = true;
        } catch (ClassCastException e) {
            System.out.println("Ошибка: нечисловые данные - " + e.getMessage());
            errors = true;
        } finally {
            if (errors) {
                System.out.println("Программа завершена с ошибками.");
            } else {
                System.out.println("Программа завершена успешно.");
            }
        }
    }
}
