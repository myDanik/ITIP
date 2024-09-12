package Tasks1of6;

public class Task5 {
    public static void main(String[] args) {
        float a = 1;
        float b = 11;
        System.out.println(ternaryEvaluation(a,b));
    }
    public static float ternaryEvaluation(float a, float b) {
        return a>b ? a:b;
    }
}
