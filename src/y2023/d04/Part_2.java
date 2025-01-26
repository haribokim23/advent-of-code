package y2023.d04;

// 제목 : Scratchcards

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        int card = 1;
        HashMap<Integer, Integer> copies = new HashMap<>();
        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] numbers = line.split(": ")[1].split(" \\| ");
            StringTokenizer st = new StringTokenizer(numbers[0]);
            HashSet<Integer> winningNumbers = new HashSet<>();

            while (st.hasMoreTokens()) {
                winningNumbers.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(numbers[1]);
            HashSet<Integer> myNumbers = new HashSet<>();

            while (st.hasMoreTokens()) {
                myNumbers.add(Integer.parseInt(st.nextToken()));
            }

            myNumbers.retainAll(winningNumbers);
            int count = copies.getOrDefault(card, 1);

            for (int offset = 1; offset <= myNumbers.size(); offset++) {
                int cardBelow = card + offset;
                copies.put(cardBelow, copies.getOrDefault(cardBelow, 1) + count);
            }

            sum += count;
            card++;
        }

        System.out.println(sum);
    }
}
