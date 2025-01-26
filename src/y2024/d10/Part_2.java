package y2024.d10;

// 제목 : Hoof It

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Part_2 {
    private static final ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int rowIndex = 0;
        ArrayList<int[]> starts = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                if (line.charAt(columnIndex) == '.') {
                    row.add(-1);
                    continue;
                }

                int height = line.charAt(columnIndex) - '0';
                row.add(height);

                if (height == 0) {
                    starts.add(new int[]{rowIndex, columnIndex});
                }
            }

            map.add(row);
            rowIndex++;
        }

        int count = 0;

        for (int[] start : starts) {
            count += backtrack(start[0], start[1]);
        }

        System.out.println(count);
    }

    private static int backtrack(int row, int column) {
        int height = map.get(row).get(column);

        if (height == 9) {
            return 1;
        }

        height++;
        int count = 0;
        int up = row - 1;

        if (up >= 0 && map.get(up).get(column) == height) {
            count += backtrack(up, column);
        }

        int down = row + 1;

        if (down < map.size() && map.get(down).get(column) == height) {
            count += backtrack(down, column);
        }

        int left = column - 1;

        if (left >= 0 && map.get(row).get(left) == height) {
            count += backtrack(row, left);
        }

        int right = column + 1;

        if (right < map.size() && map.get(row).get(right) == height) {
            count += backtrack(row, right);
        }

        return count;
    }
}
