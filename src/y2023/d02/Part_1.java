package y2023.d02;

// 제목 : Cube Conundrum

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] lineSplit = line.split(": ");
            int id = Integer.parseInt(lineSplit[0].split(" ")[1]);
            boolean impossible = false;

            for (String set : lineSplit[1].split("; ")) {
                for (String cube : set.split(", ")) {
                    String[] cubesSplit = cube.split(" ");
                    int count = Integer.parseInt(cubesSplit[0]);

                    switch (cubesSplit[1]) {
                        case "red":
                            impossible = count > 12;
                            break;
                        case "green":
                            impossible = count > 13;
                            break;
                        case "blue":
                            impossible = count > 14;
                            break;
                    }

                    if (impossible) {
                        break;
                    }
                }

                if (impossible) {
                    break;
                }
            }

            if (!impossible) {
                sum += id;
            }
        }

        System.out.println(sum);
    }
}
