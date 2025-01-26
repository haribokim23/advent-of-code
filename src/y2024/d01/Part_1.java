package y2024.d01;

// 제목 : Historian Hysteria

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line);
            left.add(Integer.parseInt(st.nextToken()));
            right.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(left);
        Collections.sort(right);
        int sum = 0;

        for (int index = 0; index < left.size(); index++) {
            sum += Math.abs(left.get(index) - right.get(index));
        }

        System.out.println(sum);
    }
}
