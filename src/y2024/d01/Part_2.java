package y2024.d01;

// 제목 : Historian Hysteria

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line);
            list.add(Integer.parseInt(st.nextToken()));
            int number = Integer.parseInt(st.nextToken());
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        int sum = 0;

        for (int number : list) {
            sum += number * count.getOrDefault(number, 0);
        }

        System.out.println(sum);
    }
}
