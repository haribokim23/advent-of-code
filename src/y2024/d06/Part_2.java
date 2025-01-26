package y2024.d06;

// 제목 : Guard Gallivant

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashSet;

public class Part_2 {
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

        for (int obstructionRow = 0; obstructionRow < rows; obstructionRow++) {
            for (int obstructionColumn = 0; obstructionColumn < columns; obstructionColumn++) {
                if ((obstructionRow == positionRow && obstructionColumn == positionColumn)
                        || map.get(obstructionRow).get(obstructionColumn) == '#') {
                    continue;
                }

                map.get(obstructionRow).set(obstructionColumn, '#');
                int currentPositionRow = positionRow;
                int currentPositionColumn = positionColumn;
                int currentDirectionRow = directionRow;
                int currentDirectionColumn = directionColumn;
                HashSet<String> positions = new HashSet<>();

                while (true) {
                    String position = currentPositionRow + " " + currentPositionColumn + " "
                            + currentDirectionRow + " " + currentDirectionColumn;

                    if (positions.contains(position)) {
                        count++;
                        break;
                    }

                    positions.add(position);

                    int nextPositionRow = currentPositionRow + currentDirectionRow;
                    int nextPositionColumn = currentPositionColumn + currentDirectionColumn;

                    if (0 > nextPositionRow || nextPositionRow >= rows || 0 > nextPositionColumn
                            || nextPositionColumn >= columns) {
                        break;
                    }

                    if (map.get(nextPositionRow).get(nextPositionColumn) == '#') {
                        if (currentDirectionRow == 0) {
                            currentDirectionRow = currentDirectionColumn;
                            currentDirectionColumn = 0;
                        } else {
                            currentDirectionColumn = currentDirectionRow * -1;
                            currentDirectionRow = 0;
                        }

                        nextPositionRow = currentPositionRow + currentDirectionRow;
                        nextPositionColumn = currentPositionColumn + currentDirectionColumn;

                        if (0 > nextPositionRow || nextPositionRow >= rows || 0 > nextPositionColumn
                                || nextPositionColumn >= columns) {
                            break;
                        }

                        if (map.get(nextPositionRow).get(nextPositionColumn) == '#') {
                            if (currentDirectionRow == 0) {
                                currentDirectionRow = currentDirectionColumn;
                                currentDirectionColumn = 0;
                            } else {
                                currentDirectionColumn = currentDirectionRow * -1;
                                currentDirectionRow = 0;
                            }
                        }
                    }

                    currentPositionRow += currentDirectionRow;
                    currentPositionColumn += currentDirectionColumn;
                }

                map.get(obstructionRow).set(obstructionColumn, '.');
            }
        }

        System.out.println(count);
    }
}
