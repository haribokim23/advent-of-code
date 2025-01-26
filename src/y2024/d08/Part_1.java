package y2024.d08;

// 제목 : Resonant Collinearity

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        ArrayList<ArrayList<Character>> map = new ArrayList<>();
        HashMap<Character, ArrayList<String>> frequencies = new HashMap<>();
        int rowIndex = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            ArrayList<Character> row = new ArrayList<>();

            for (int columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                char character = line.charAt(columnIndex);
                row.add(character);

                if (character == '.') {
                    continue;
                }

                frequencies.putIfAbsent(character, new ArrayList<>());
                frequencies.get(character).add(rowIndex + " " + columnIndex);
            }

            map.add(row);
            rowIndex++;
        }

        int rows = map.size();
        int columns = map.getFirst().size();
        HashSet<String> antinodes = new HashSet<>();

        for (HashMap.Entry<Character, ArrayList<String>> entry : frequencies.entrySet()) {
            char frequency = entry.getKey();
            ArrayList<String> antennas = entry.getValue();
            int size = antennas.size();

            for (int left = 0; left < size - 1; left++) {
                StringTokenizer st = new StringTokenizer(antennas.get(left));
                int leftRow = Integer.parseInt(st.nextToken());
                int leftColumn = Integer.parseInt(st.nextToken());

                for (int right = left + 1; right < size; right++) {
                    st = new StringTokenizer(antennas.get(right));
                    int rightRow = Integer.parseInt(st.nextToken());
                    int rightColumn = Integer.parseInt(st.nextToken());

                    int differenceRow = leftRow - rightRow;
                    int differenceColumn = leftColumn - rightColumn;

                    int antinodeRow = leftRow + differenceRow;
                    int antinodeColumn = leftColumn + differenceColumn;
                    String antinode = antinodeRow + " " + antinodeColumn;

                    if (0 <= antinodeRow && antinodeRow < rows && 0 <= antinodeColumn
                            && antinodeColumn < columns && !antinodes.contains(antinode) && map.get(
                            antinodeRow).get(antinodeColumn) != frequency) {
                        antinodes.add(antinode);
                    }

                    antinodeRow = leftRow - differenceRow;
                    antinodeColumn = leftColumn - differenceColumn;
                    antinode = antinodeRow + " " + antinodeColumn;

                    if (0 <= antinodeRow && antinodeRow < rows && 0 <= antinodeColumn
                            && antinodeColumn < columns && !antinodes.contains(antinode) && map.get(
                            antinodeRow).get(antinodeColumn) != frequency) {
                        antinodes.add(antinode);
                    }

                    antinodeRow = rightRow + differenceRow;
                    antinodeColumn = rightColumn + differenceColumn;
                    antinode = antinodeRow + " " + antinodeColumn;

                    if (0 <= antinodeRow && antinodeRow < rows && 0 <= antinodeColumn
                            && antinodeColumn < columns && !antinodes.contains(antinode) && map.get(
                            antinodeRow).get(antinodeColumn) != frequency) {
                        antinodes.add(antinode);
                    }

                    antinodeRow = rightRow - differenceRow;
                    antinodeColumn = rightColumn - differenceColumn;
                    antinode = antinodeRow + " " + antinodeColumn;

                    if (0 <= antinodeRow && antinodeRow < rows && 0 <= antinodeColumn
                            && antinodeColumn < columns && !antinodes.contains(antinode) && map.get(
                            antinodeRow).get(antinodeColumn) != frequency) {
                        antinodes.add(antinode);
                    }
                }
            }
        }

        System.out.println(antinodes.size());
    }
}
