package y2024.d10;

// 제목 : Hoof It

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashSet;

public class Part_1 {
    private static final ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    private static HashSet<String> ends;

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
            ends = new HashSet<>();
            backtrack(start[0], start[1]);
            count += ends.size();
        }

        System.out.println(count);
    }

    private static void backtrack(int row, int column) {
        int height = map.get(row).get(column);

        if (height == 9) {
            ends.add(row + " " + column);
        }

        height++;
        int up = row - 1;

        if (up >= 0 && map.get(up).get(column) == height) {
            backtrack(up, column);
        }

        int down = row + 1;

        if (down < map.size() && map.get(down).get(column) == height) {
            backtrack(down, column);
        }

        int left = column - 1;

        if (left >= 0 && map.get(row).get(left) == height) {
            backtrack(row, left);
        }

        int right = column + 1;

        if (right < map.size() && map.get(row).get(right) == height) {
            backtrack(row, right);
        }
    }
}
