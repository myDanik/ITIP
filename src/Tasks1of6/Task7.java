package Tasks1of6;

public class Task7 {
    public static void main(String[] args) {
        int num = 7;
        if (num <= 1) {
            System.out.println("Введите число > 1");
        }
        System.out.println(factorial(num));
    }
    public static int factorial(int num) {
        int fctrl = 1;
        for (int i = 1; i <= num; i++) {
            fctrl *= i;
        }
        return fctrl;
    }

}
