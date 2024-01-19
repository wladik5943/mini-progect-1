package dataClasses;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAcc {

    public static void create() throws IOException {
        File[] arr = new File("D:\\progects\\mini-progect-1\\src\\transaction").listFiles();
        FileWriter file = new FileWriter("D:\\progects\\mini-progect-1\\src\\accounts.txt");
        file.write("");
        file.flush();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            read(arr[i],map);
        }
    }


    private static void read(File file, Map<String,Integer> map) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\progects\\mini-progect-1\\src\\accounts.txt",true);
        FileReader fileReader = new FileReader(file);
        char[] arr = new char[100];
        int count = 0;
        if(count < 2) {
            fileReader.read(arr);
                String st = new String(arr);
                String str = "\\d{5}-\\d{5}";
                Pattern pattern = Pattern.compile(str);
                Matcher matcher = pattern.matcher(st);
            while (count < 2) {
                if (matcher.find()) {
                    if (!map.containsKey(matcher.group())) {
                        map.put(matcher.group(),2500);
                        fileWriter.write(matcher.group() + "  2500\n");
                        fileWriter.flush();
                        count++;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
    }
}
