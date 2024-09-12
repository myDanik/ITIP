package Tasks1of6;

public class Task6 {
    public static void main(String[] args) {
        int n = 100;
        float w = 2f;
        float h = 2f;
        System.out.println(howManyItems(n,w,h));
    }
    public static int howManyItems(int n, float w, float h) {
        System.out.println((int)( (n/2) / (w*h)));
        return 1;
    }
}
