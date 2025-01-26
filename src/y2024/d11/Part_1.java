package y2024.d11;

// 제목 : Plutonian Pebbles

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> stones = new ArrayList<>();

        while (st.hasMoreTokens()) {
            stones.add(Long.parseLong(st.nextToken()));
        }

        for (int count = 0; count < 25; count++) {
            ArrayList<Long> nextStones = new ArrayList<>();

            for (long stone : stones) {
                int stoneLength = (int) Math.log10(stone) + 1;

                if (stone == 0) {
                    nextStones.add(1L);
                } else if (stoneLength % 2 == 0) {
                    int nextStoneLength = stoneLength / 2;
                    nextStones.add(stone / (int) Math.pow(10, nextStoneLength));
                    nextStones.add(stone % (int) Math.pow(10, nextStoneLength));
                } else {
                    nextStones.add(stone * 2024);
                }
            }

            stones = nextStones;
        }

        System.out.println(stones.size());
    }
}
