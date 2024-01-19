package model;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Master {

    public static void run() throws IOException {
            Map<String, Integer> map = Acc.accounts();
            File[] files = new File("D:\\progects\\mini-progect-1\\src\\transaction").listFiles();
            Transfers.run(map, files);
            UpdateAcc.run(map);
    }
}
