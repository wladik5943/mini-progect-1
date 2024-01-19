package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Acc {
    public static Map<String, Integer> accounts() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\progects\\mini-progect-1\\src\\accounts.txt"));
        Map<String,Integer> map = new HashMap<>();
        Stream<String> stream = bufferedReader.lines();
        String str = "\\d{5}-\\d{5}";
        String str1 = "\\d{1,4}$";
        Pattern pattern = Pattern.compile(str);
        Pattern pattern1 = Pattern.compile(str1);
        stream.forEach(x -> {
            Matcher matcher = pattern.matcher(x);
            Matcher matcher1 = pattern1.matcher(x);
            matcher.find();
            matcher1.find();
                map.put(matcher.group(), Integer.parseInt(matcher1.group()));
        });

        return map;
    }
}
