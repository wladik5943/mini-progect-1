package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class UpdateAcc {

    public static void run(Map<String, Integer> map) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\progects\\mini-progect-1\\src\\accounts.txt");
        String[] arr = new String[map.size()];
        map.keySet().toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            fileWriter.write(arr[i] + " " + map.get(arr[i]) + "\n");
            fileWriter.flush();
        }
    }
}
