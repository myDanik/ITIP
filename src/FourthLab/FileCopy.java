package FourthLab;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        boolean errors = false;
        try (FileReader fileReader = new FileReader("src/FourthLab/from.txt");
             FileWriter fileWriter = new FileWriter("src/FourthLab/to.txt")) {
//           fileReader.close();
            int i = fileReader.read();
            while (i != -1) {
                fileWriter.write(i);
                i = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            errors = true;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());
            errors = true;
        }finally {
            if (errors) {
                System.out.println("Операция завершена с ошибками.");
            } else {
                System.out.println("Операция завершена успешно.");
            }
        }
    }
}
