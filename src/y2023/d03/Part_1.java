package y2023.d03;

// 제목 : Gear Ratios

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int length = 0;
        boolean[][] isPart = null;
        char[][] schematic = null;
        int rowIndex = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            char[] l = line.toCharArray();

            if (length == 0) {
                length = l.length;
                isPart = new boolean[length][length];
                schematic = new char[length][length];
            }

            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                char character = l[columnIndex];

                if (character != '.' && !Character.isDigit(character)) {
                    int top = Math.max(rowIndex - 1, 0);
                    int bottom = Math.min(rowIndex + 1, length - 1);
                    int left = Math.max(columnIndex - 1, 0);
                    int right = Math.min(columnIndex + 1, length - 1);
                    isPart[top][left] = true;
                    isPart[top][columnIndex] = true;
                    isPart[top][right] = true;
                    isPart[rowIndex][left] = true;
                    isPart[rowIndex][right] = true;
                    isPart[bottom][left] = true;
                    isPart[bottom][columnIndex] = true;
                    isPart[bottom][right] = true;
                }
            }

            schematic[rowIndex++] = l;
        }

        int sum = 0;

        for (rowIndex = 0; rowIndex < length; rowIndex++) {
            char[] row = schematic[rowIndex];

            for (int columnIndex = 0; columnIndex < length; ) {
                char character = row[columnIndex++];

                if (!Character.isDigit(character)) {
                    continue;
                }

                int partNumber = character - '0';
                boolean isAdjacent = isPart[rowIndex][columnIndex - 1];

                while (columnIndex < length) {
                    character = row[columnIndex];

                    if (!Character.isDigit(character)) {
                        break;
                    }

                    partNumber = partNumber * 10 + character - '0';
                    isAdjacent |= isPart[rowIndex][columnIndex++];
                }

                if (isAdjacent) {
                    sum += partNumber;
                }
            }
        }

        System.out.println(sum);
    }
}
