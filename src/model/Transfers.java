package model;

import exeption.AbsentAcc;
import exeption.NoMoney;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Transfers {

    public static void run(Map<String, Integer> map, File[] files) throws IOException {
            FileWriter fileWriter = new FileWriter("result.txt",true);
            for (int i = 0; i < files.length; i++) {
                try {
                String[] arr = readTransac(files[i]);
                int sum = Integer.parseInt(arr[2]);
                check(map,arr);
                map.put(arr[0], map.get(arr[0]) - sum);
                map.put(arr[1], map.get(arr[1]) + sum);
                fileWriter.write(LocalDate.now().toString() + " - " + LocalTime.now().toString() + files[i].getName() + " - успешно обработан\n");
                fileWriter.flush();
                }
                catch (AbsentAcc e){
                    fileWriter.write(LocalDate.now().toString() + " - " + LocalTime.now().toString() + " - " +files[i].getName() + " - ОШИБКА: счет " + e.getAcc() + " не существует\n");
                    fileWriter.flush();
                }
                catch (NoMoney e){
                    fileWriter.write(LocalDate.now().toString() + " - " + LocalTime.now().toString() + " - " +files[i].getName() + " - ОШИБКА: на счете " + e.getAcc() + " не достаточно средств\n");
                    fileWriter.flush();
                }
            }

    }

    private static void check(Map<String, Integer> map,String[] arr) throws AbsentAcc, NoMoney {
        for (int i = 0; i < 2; i++) {
            if(!map.containsKey(arr[i]))
                throw new AbsentAcc(arr[i]);
        }
        if(map.get(arr[0]) < Integer.parseInt(arr[2]))
            throw new NoMoney(arr[0]);

    }

    private static String[] readTransac(File file) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Stream<String> stream = bufferedReader.lines();
        String[] arr = new String[3];
        String str = "\\d{5}-\\d{5}";
        String str1 = "^\\d{1,4}$";
        Pattern pattern = Pattern.compile(str);
        Pattern pattern1 = Pattern.compile(str1);

        stream.forEach(x -> {
            Matcher matcher = pattern.matcher(x);
            Matcher matcher1 = pattern1.matcher(x);
            boolean flag = matcher.find();
               if(flag && arr[0] == null)
                arr[0] = matcher.group();
            else if (flag)
                arr[1] = matcher.group();

            if(matcher1.find())
            arr[2] = matcher1.group();
        });
        return arr;
    }
}
