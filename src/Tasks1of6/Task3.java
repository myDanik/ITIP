package Tasks1of6;

public class Task3 {
    public static void main(String[] args) {
        int box = 3;
        int bag = 4;
        int barrel = 2;
        System.out.println(containers(box, bag, barrel));
    }
    public static int containers(int box, int bag, int barrel) {
        return (box*20+bag*50+barrel*100);
    }
}
