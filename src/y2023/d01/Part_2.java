package y2023.d01;

// 제목 : Trebuchet?!

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            int leftDigit = -1;
            int rightDigit = -1;

            String[] digits = new String[]{"one", "two", "three", "four", "five", "six", "seven",
                    "eight", "nine"};

            for (int index = 0; index < line.length(); index++) {
                char character = line.charAt(index);

                if (Character.isDigit(character)) {
                    int digit = character - '0';

                    if (leftDigit == -1) {
                        leftDigit = digit;
                    }

                    rightDigit = digit;
                    continue;
                }

                for (int digit = 1; digit <= digits.length; digit++) {
                    if (line.startsWith(digits[digit - 1], index)) {
                        if (leftDigit == -1) {
                            leftDigit = digit;
                        }

                        rightDigit = digit;
                    }
                }
            }

            if (leftDigit == -1 || rightDigit == -1) {
                System.out.println(line);
                System.out.println("leftDigit : " + leftDigit);
                System.out.println("rightDigit : " + rightDigit);
                return;
            }

            sum += leftDigit * 10 + rightDigit;
        }

        System.out.println(sum);
    }
}
