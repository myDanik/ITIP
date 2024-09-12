package Tasks1of6;

public class Task8 {
    public static void main(String[] args) {
        int a = 259;
        int b = 28;
        System.out.println(gcd(a, b));
    }
    public static int gcd(int a, int b) {
        int min_num = Math.min(a,b);
        int max_d = 1;

        for (int i = 1; i <= min_num ; i++) {
            if ((a % i ==0) && (b%i==0)) {
                max_d = i;
            }

        }
        return max_d;
    }
}
