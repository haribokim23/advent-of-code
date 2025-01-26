package y2024.d04;

// 제목 : Ceres Search

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

        ArrayList<ArrayList<Character>> table = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            ArrayList<Character> row = new ArrayList<>();

            for (int index = 0; index < line.length(); index++) {
                row.add(line.charAt(index));
            }

            table.add(row);
        }

        int rows = table.size();
        int columns = table.getFirst().size();
        String word = "MAS";
        int length = word.length();
        int count = 0;

        for (int row = 0; row < rows - length + 1; row++) {
            for (int column = 0; column < columns - length + 1; column++) {
                boolean rightDownFound = true;
                boolean leftUpFound = true;
                boolean rightUpFound = true;
                boolean leftDownFound = true;

                for (int index = 0; index < length; index++) {
                    int reverseIndex = length - index - 1;

                    if (table.get(row + index).get(column + index) != word.charAt(index)) {
                        rightDownFound = false;
                    }

                    if (table.get(row + index).get(column + index) != word.charAt(reverseIndex)) {
                        leftUpFound = false;
                    }

                    if (table.get(row + reverseIndex).get(column + index) != word.charAt(index)) {
                        rightUpFound = false;
                    }

                    if (table.get(row + reverseIndex).get(column + index) != word.charAt(
                            reverseIndex)) {
                        leftDownFound = false;
                    }
                }

                if ((rightDownFound || leftUpFound) && (rightUpFound || leftDownFound)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
