import dataClasses.CreateAcc;
import dataClasses.GeneratorTransac;
import model.Master;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1-Создание файлов с транзакциями");
            System.out.println("2-Создание базы аккаунтов на основе файлов с транзакциями");
            System.out.println("3-обработка транзакций");
            System.out.println("4-выход");
            switch (scanner.nextInt()){
                case 1 -> GeneratorTransac.createFiles();
                case 2 -> CreateAcc.create();
                case 3 -> Master.run();
                case 4 -> exit(0);
                default -> System.out.println("введено недопустимое значение");
            }
        }

    }
}