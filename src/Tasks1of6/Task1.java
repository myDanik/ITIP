package Tasks1of6;

public class Task1 {
    public static void main(String[] args) {
        int gallons = 5;
        System.out.println(convertToLiters(gallons));
    }

    public static double convertToLiters(double gallons) {
        double liters = gallons * 3.785;
        return liters;


    }
}
