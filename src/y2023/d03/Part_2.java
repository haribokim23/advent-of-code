package y2023.d03;

// 제목 : Gear Ratios

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int length = 0;
        char[][] schematic = null;
        int rowIndex = 0;
        ArrayList<Gear> gears = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            char[] l = line.toCharArray();

            if (length == 0) {
                length = l.length;
                schematic = new char[length][length];
            }

            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                char character = l[columnIndex];

                if (character == '*') {
                    gears.add(new Gear(rowIndex, columnIndex));
                }
            }

            schematic[rowIndex++] = l;
        }

        for (rowIndex = 0; rowIndex < length; rowIndex++) {
            char[] row = schematic[rowIndex];

            for (int columnIndex = 0; columnIndex < length; ) {
                int columnStart = Math.max(columnIndex - 1, 0);
                char character = row[columnIndex++];

                if (!Character.isDigit(character)) {
                    continue;
                }

                int partNumber = character - '0';

                while (columnIndex < length) {
                    character = row[columnIndex++];

                    if (!Character.isDigit(character)) {
                        break;
                    }

                    partNumber = partNumber * 10 + character - '0';
                }

                int columnEnd = Math.min(columnIndex - 1, length - 1);

                for (Gear gear : gears) {
                    int gearColumnIndex = gear.columnIndex;

                    if (Math.abs(rowIndex - gear.rowIndex) <= 1 && columnStart <= gearColumnIndex
                            && gearColumnIndex <= columnEnd) {
                        gear.parts++;
                        gear.ratio *= partNumber;
                    }
                }
            }
        }

        int sum = 0;

        for (Gear gear : gears) {
            if (gear.parts == 2) {
                sum += gear.ratio;
            }
        }

        System.out.println(sum);
    }

    private static class Gear {
        public int rowIndex;
        public int columnIndex;
        public int parts = 0;
        public int ratio = 1;

        public Gear(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }
}
