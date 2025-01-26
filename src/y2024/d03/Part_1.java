package y2024.d03;

// 제목 : Mull It Over

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

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            for (int index = 0; index < line.length(); index++) {
                for (int length = 8; length <= 12; length++) {
                    if (index + length > line.length()) {
                        continue;
                    }

                    String substring = line.substring(index, index + length);

                    if (substring.matches("mul\\(\\d{1,3},\\d{1,3}\\)")) {
                        StringTokenizer st = new StringTokenizer(
                                substring.substring(4, substring.length() - 1), ",");

                        sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
