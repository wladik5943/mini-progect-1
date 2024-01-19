package dataClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GeneratorTransac {

    public static void createFiles() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите количество создаваемых транзакций");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            create(i);
        }
    }



    private static void create(int i) throws IOException {
        File file = new File("D:\\progects\\mini-progect-1\\src\\transaction\\transaction-" + i + ".txt");
        file.createNewFile();
        writeBankAcc(file.getAbsolutePath()); //счет с которого переводят
        writeBankAcc(file.getAbsolutePath()); //счет на который переводят
        summ(file.getAbsolutePath());
    }

    private  static void summ(String way) throws IOException {
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(way,true);
        Integer n = random.nextInt(1,1000);
        fileWriter.write(n.toString());
        fileWriter.flush();
    }

    private static void writeBankAcc(String way) throws IOException {
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(way,true);
        for (int j = 0; j < 5; j++) {
            Integer n = random.nextInt(0,9);
            fileWriter.write(n.toString());
            fileWriter.flush();
        }
        fileWriter.write("-");
        fileWriter.flush();
        for (int j = 0; j < 5; j++) {
            Integer n = random.nextInt(0,9);
            fileWriter.write(n.toString());
            fileWriter.flush();
        }
        fileWriter.write("\n");
        fileWriter.flush();
    }

}