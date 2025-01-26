package y2023.d01;

// 제목 : Trebuchet?!

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            int lineLength = line.length();
            int leftDigit = -1;

            for (int index = 0; index < lineLength; index++) {
                char character = line.charAt(index);

                if (Character.isDigit(character)) {
                    leftDigit = character - '0';
                    break;
                }
            }

            int rightDigit = -1;

            for (int index = lineLength - 1; index >= 0; index--) {
                char character = line.charAt(index);

                if (Character.isDigit(character)) {
                    rightDigit = character - '0';
                    break;
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
