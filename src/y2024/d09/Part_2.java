package y2024.d09;

// 제목 : Disk Fragmenter

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

        String line = br.readLine();
        ArrayList<int[]> files = new ArrayList<>();

        for (int index = 0, id = 0; index < line.length(); index++) {
            files.add(new int[]{index % 2 == 0 ? id++ : -1, line.charAt(index) - '0'});
        }

        int length = files.size();

        for (int leftIndex = 0; leftIndex < length; leftIndex++) {
            int[] left = files.get(leftIndex);

            if (left[0] != -1) {
                continue;
            }

            int rightIndex = length - 1;

            while (leftIndex < rightIndex && (files.get(rightIndex)[0] == -1 || left[1] < files.get(
                    rightIndex)[1])) {
                rightIndex--;
            }

            int[] right = files.get(rightIndex);
            files.set(leftIndex, right);
            files.set(rightIndex, new int[]{-1, right[1]});

            if (left[1] > right[1]) {
                files.add(leftIndex + 1, new int[]{-1, left[1] - right[1]});
            }
        }

        int index = 0;
        long sum = 0;

        for (int[] file : files) {
            for (int count = 0; count < file[1]; count++) {
                if (file[0] != -1) {
                    sum += (long) index * file[0];
                }

                index++;
            }
        }

        System.out.println(sum);
    }
}
