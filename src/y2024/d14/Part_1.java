package y2024.d14;

// 제목 : Restroom Redoubt

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

        int width = 101;
        int height = 103;
        ArrayList<int[]> positions = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line);
            String position = st.nextToken();
            String velocity = st.nextToken();

            st = new StringTokenizer(position, "=");
            st.nextToken();
            st = new StringTokenizer((st.nextToken()), ",");
            int positionX = Integer.parseInt(st.nextToken());
            int positionY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(velocity, "=");
            st.nextToken();
            st = new StringTokenizer((st.nextToken()), ",");
            int velocityX = Integer.parseInt(st.nextToken());
            int velocityY = Integer.parseInt(st.nextToken());

            for (int count = 0; count < 100; count++) {
                positionX = (positionX + velocityX + width) % width;
                positionY = (positionY + velocityY + height) % height;
            }

            positions.add(new int[]{positionX, positionY});
        }

        int xAxis = height / 2;
        int yAxis = width / 2;
        int quadrant1 = 0;
        int quadrant2 = 0;
        int quadrant3 = 0;
        int quadrant4 = 0;

        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];

            if (x == yAxis || y == xAxis) {
                continue;
            }

            if (y > xAxis) {
                if (x > yAxis) {
                    quadrant1++;
                } else {
                    quadrant2++;
                }
            } else {
                if (x < yAxis) {
                    quadrant3++;
                } else {
                    quadrant4++;
                }
            }
        }

        System.out.println(quadrant1 * quadrant2 * quadrant3 * quadrant4);
    }
}
