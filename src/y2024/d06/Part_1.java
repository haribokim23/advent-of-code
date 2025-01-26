package y2024.d06;

// 제목 : Guard Gallivant

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        boolean positionRowFound = false;
        int positionRow = 0;
        int positionColumn = 0;
        int directionRow = 0;
        int directionColumn = 0;
        ArrayList<ArrayList<Character>> map = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            ArrayList<Character> row = new ArrayList<>();

            for (int index = 0; index < line.length(); index++) {
                char character = line.charAt(index);

                if (character == '.' || character == '#') {
                    row.add(character);
                    continue;
                }

                positionRowFound = true;
                positionColumn = index;

                switch (character) {
                    case '>':
                        directionColumn = 1;
                        break;
                    case '<':
                        directionColumn = -1;
                        break;
                    case '^':
                        directionRow = -1;
                        break;
                    case 'v':
                        directionRow = 1;
                        break;
                }

                row.add('.');
            }

            map.add(row);

            if (!positionRowFound) {
                positionRow++;
            }
        }

        int rows = map.size();
        int columns = map.getFirst().size();
        int count = 0;

        while (true) {
            if (map.get(positionRow).get(positionColumn) == '.') {
                map.get(positionRow).set(positionColumn, 'X');
                count++;
            }

            int nextPositionRow = positionRow + directionRow;
            int nextPositionColumn = positionColumn + directionColumn;

            if (0 > nextPositionRow || nextPositionRow >= rows || 0 > nextPositionColumn
                    || nextPositionColumn >= columns) {
                break;
            }

            if (map.get(nextPositionRow).get(nextPositionColumn) == '#') {
                if (directionRow == 0) {
                    directionRow = directionColumn;
                    directionColumn = 0;
                } else {
                    directionColumn = directionRow * -1;
                    directionRow = 0;
                }
            }

            positionRow += directionRow;
            positionColumn += directionColumn;
        }

        System.out.println(count);
    }
}
