//GitHub: https://github.com/myDanik/ITIP/tree/master/src/Tasks1of6
package Tasks1of6;

public class CombinedTasks1of6 {
    public static void main(String[] args) {
        // Task 1
        int gallons = 5;
        System.out.println("Task 1: " + convertToLiters(gallons));

        // Task 2
        int time = 24;
        int intensity = 2;
        System.out.println("Task 2: " + fitCalc(time, intensity));

        // Task 3
        int box = 3;
        int bag = 4;
        int barrel = 2;
        System.out.println("Task 3: " + containers(box, bag, barrel));

        // Task 4
        int x = 1, y = 1, z = 5;
        System.out.println("Task 4: " + triangleType(x, y, z));

        // Task 5
        float a = 1;
        float b = 11;
        System.out.println("Task 5: " + ternaryEvaluation(a, b));

        // Task 6
        int n = 100;
        float w = 2f, h = 2f;
        System.out.println("Task 6: " + howManyItems(n, w, h));

        // Task 7
        int num = 7;
        if (num <= 1) {
            System.out.println("Task 7: Введите число > 1");
        } else {
            System.out.println("Task 7: " + factorial(num));
        }

        // Task 8
        int a1 = 259;
        int b1 = 28;
        System.out.println("Task 8: " + gcd(a1, b1));

        // Task 9
        int cnt = 53;
        int price = 1250;
        System.out.println("Task 9: " + ticketSaler(cnt, price));

        // Task 10
        int students = 123;
        int table = 58;
        System.out.println("Task 10: " + tables(students, table));
    }

    // Task 1
    public static double convertToLiters(double gallons) {
        return gallons * 3.785;
    }

    // Task 2
    public static int fitCalc(int time, int intensity) {
        return time * intensity;
    }

    // Task 3
    public static int containers(int box, int bag, int barrel) {
        return box * 20 + bag * 50 + barrel * 100;
    }

    // Task 4
    public static String triangleType(int x, int y, int z) {
        if ((x + y > z && x + z > y && y + z > x) == false) {
            return "not a triangle";
        } else {
            if (x == y && y == z) {
                return "isosceles";
            }
            if (x == y || y == z || x == z) {
                return "equilateral";
            }
            if (x != y && y != z && x != z) {
                return "different-sided";
            }
        }
        return "check the entered data";
    }

    // Task 5
    public static float ternaryEvaluation(float a, float b) {
        return a > b ? a : b;
    }

    // Task 6
    public static int howManyItems(int n, float w, float h) {
        return (int) ((n / 2) / (w * h));
    }

    // Task 7
    public static int factorial(int num) {
        int fctrl = 1;
        for (int i = 1; i <= num; i++) {
            fctrl *= i;
        }
        return fctrl;
    }

    // Task 8
    public static int gcd(int a, int b) {
        int min_num = Math.min(a, b);
        int max_d = 1;
        for (int i = 1; i <= min_num; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                max_d = i;
            }
        }
        return max_d;
    }

    // Task 9
    public static int ticketSaler(int cnt, int price) {
        return (int) (cnt * price * 0.72);
    }

    // Task 10
    public static int tables(int students, int table) {
        int need_table = students % 2 == 0 ? students / 2 : students / 2 + 1;
        return need_table - table >= 0 ? need_table - table : 0;
    }
}
