package SixthLab;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());

        SalesManager salesManager = new SalesManager();
        salesManager.addSale("Хлеб", 35.9);
        salesManager.addSale("Молоко", 120.99);
        salesManager.addSale("Хлеб", 46.5);
        salesManager.addSale("Яблоко", 32.1);
        salesManager.addSale("Молоко", 190.0);
        salesManager.printSoldProducts();
        System.out.println(salesManager.getTotalSales());
        System.out.println(salesManager.getMostPopularProduct());


    }
}
