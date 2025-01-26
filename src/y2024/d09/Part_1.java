package y2024.d09;

// 제목 : Disk Fragmenter

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

        String line = br.readLine();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int index = 0, id = 0; index < line.length(); index++) {
            int length = line.charAt(index) - '0';

            if (index % 2 == 0) {
                for (int count = 0; count < length; count++) {
                    ids.add(id);
                }

                id++;
                continue;
            }

            for (int count = 0; count < length; count++) {
                ids.add(-1);
            }
        }

        int length = ids.size();

        for (int left = 0, right = length - 1; left < length; left++) {
            if (ids.get(left) != -1) {
                continue;
            }

            while (left < right && ids.get(right) == -1) {
                right--;
            }

            ids.set(left, ids.get(right));
            ids.set(right, -1);
        }

        long sum = 0;

        for (int index = 0; index < length; index++) {
            int id = ids.get(index);

            if (id == -1) {
                break;
            }

            sum += (long) index * id;
        }

        System.out.println(sum);
    }
}
