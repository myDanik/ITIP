package Tasks1of6;

public class Task10 {
    public static void main(String[] args) {
        int students = 2131;
        int table = 1059;
        System.out.println(tables(students, table));
    }
    public static int tables(int students, int table) {
        int need_table = students%2==0 ? students/2: students/2+1;
        if (need_table-table>=0) {
            return need_table - table;
        }
        return 0;
    }


}
