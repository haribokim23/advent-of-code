package y2023.d02;

// 제목 : Cube Conundrum

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            int red = 0;
            int green = 0;
            int blue = 0;

            for (String set : line.split(": ")[1].split("; ")) {
                for (String cube : set.split(", ")) {
                    String[] cubesSplit = cube.split(" ");
                    int count = Integer.parseInt(cubesSplit[0]);

                    switch (cubesSplit[1]) {
                        case "red":
                            red = Math.max(red, count);
                            break;
                        case "green":
                            green = Math.max(green, count);
                            break;
                        case "blue":
                            blue = Math.max(blue, count);
                            break;
                    }
                }
            }

            sum += red * green * blue;
        }

        System.out.println(sum);
    }
}
