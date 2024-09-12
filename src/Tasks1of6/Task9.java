package Tasks1of6;

public class Task9 {
    public static void main(String[] args) {
        int cnt = 53;
        int price = 1250;
        System.out.println(ticketSaler(cnt, price));
    }
    public static int ticketSaler(int cnt, int price) {
        return (int) (cnt * price * 0.72);
    }
}
