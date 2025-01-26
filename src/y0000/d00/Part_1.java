package y0000.d00;

// 제목 : -

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

public class Part_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            //
        }
    }
}
