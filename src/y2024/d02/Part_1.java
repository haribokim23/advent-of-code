package y2024.d02;

// 제목 : Red-Nosed Reports

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.StringTokenizer;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int count = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line);
            int previous = Integer.parseInt(st.nextToken());
            boolean adjacent = true;
            boolean increasing = true;
            boolean decreasing = true;

            while (st.hasMoreTokens()) {
                int current = Integer.parseInt(st.nextToken());
                int difference = Math.abs(previous - current);

                if (difference < 1 || difference > 3) {
                    adjacent = false;
                    break;
                }

                if (increasing && previous < current) {
                    increasing = false;
                }

                if (decreasing && previous > current) {
                    decreasing = false;
                }

                previous = current;
            }

            if (adjacent && (increasing || decreasing)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
