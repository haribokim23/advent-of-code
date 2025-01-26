package y2024.d02;

// 제목 : Red-Nosed Reports

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int count = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] list = line.split(" ");

            for (int skip = 0; skip < list.length; skip++) {
                int previous = -1;
                boolean adjacent = true;
                boolean increasing = true;
                boolean decreasing = true;

                for (int index = 0; index < list.length; index++) {
                    if (index == skip) {
                        continue;
                    }

                    if (previous == -1) {
                        previous = Integer.parseInt(list[index]);
                        continue;
                    }

                    int current = Integer.parseInt(list[index]);
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
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
