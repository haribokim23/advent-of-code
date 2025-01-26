package y2024.d13;

// 제목 : Claw Contraption

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
            StringTokenizer st1 = new StringTokenizer(line, ",");
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            st2.nextToken();
            int ax = Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st1.nextToken(), "+");
            st2.nextToken();
            int ay = Integer.parseInt(st2.nextToken());

            st1 = new StringTokenizer(br.readLine(), ",");
            st2 = new StringTokenizer(st1.nextToken(), "+");
            st2.nextToken();
            int bx = Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st1.nextToken(), "+");
            st2.nextToken();
            int by = Integer.parseInt(st2.nextToken());

            st1 = new StringTokenizer(br.readLine(), ",");
            st2 = new StringTokenizer(st1.nextToken(), "=");
            st2.nextToken();
            int prizeX = Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st1.nextToken(), "=");
            st2.nextToken();
            int prizeY = Integer.parseInt(st2.nextToken());

            boolean count = false;
            int minTokens = 400;

            for (int aCount = 0; aCount <= 100; aCount++) {
                int remainingX = prizeX - ax * aCount;
                int remainingY = prizeY - ay * aCount;

                if (remainingX < 0 || remainingY < 0) {
                    break;
                }

                int bCount = remainingX / bx;

                if (remainingX % bx == 0 && remainingY % by == 0 && bCount == remainingY / by
                        && bCount <= 100) {
                    count = true;
                    int tokens = 3 * aCount + bCount;

                    if (tokens < minTokens) {
                        minTokens = tokens;
                    }
                }
            }

            if (count) {
                sum += minTokens;
            }

            br.readLine();
        }

        System.out.println(sum);
    }
}
