package Tasks1of6;

public class Task4 {
    public static void main(String args []) {
        int x = 1;
        int y = 1;
        int z = 5;
        System.out.println(triangleType(x,y,z));
    }
    public static String triangleType(int x, int y, int z) {
        if ((x+y>z && x+z>y && y+z>x)==false) {
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
}
