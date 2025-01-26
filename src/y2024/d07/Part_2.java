package y2024.d07;

// 제목 : Bridge Repair

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Part_2 {
    private static long testValue;
    private static ArrayList<Long> numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        long sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line);
            testValue = Long.parseLong(st.nextToken().split(":")[0]);
            long startValue = Long.parseLong(st.nextToken());
            numbers = new ArrayList<>();

            while (st.hasMoreTokens()) {
                numbers.add(Long.parseLong(st.nextToken()));
            }

            if (backtrack(startValue, 0) > 0) {
                sum += testValue;
            }
        }

        System.out.println(sum);
    }

    private static int backtrack(long value, int index) {
        long number = numbers.get(index);
        long sum = value + number;
        long product = value * number;
        long concat = Long.parseLong(Long.toString(value) + number);

        if (index == numbers.size() - 1) {
            int count = 0;

            if (sum == testValue) {
                count++;
            }

            if (product == testValue) {
                count++;
            }

            if (concat == testValue) {
                count++;
            }

            return count;
        }

        return backtrack(sum, index + 1) + backtrack(product, index + 1) + backtrack(concat,
                index + 1);
    }
}
