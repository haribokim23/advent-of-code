package y2024.d05;

// 제목 : Print Queue

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Part_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(
                "advent-of-code-inputs/" + MethodHandles.lookup().lookupClass().getPackageName()
                        .replace(".", "/") + "/Input.txt").getAbsolutePath()));

        HashMap<Integer, HashSet<Integer>> rules = new HashMap<>();

        for (String line = br.readLine(); !line.isEmpty(); line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line, "|");
            int page = Integer.parseInt(st.nextToken());
            rules.putIfAbsent(page, new HashSet<>());
            rules.get(page).add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            StringTokenizer st = new StringTokenizer(line, ",");
            ArrayList<Integer> update = new ArrayList<>();

            while (st.hasMoreTokens()) {
                update.add(Integer.parseInt(st.nextToken()));
            }

            boolean rightOrder = true;

            for (HashMap.Entry<Integer, HashSet<Integer>> entry : rules.entrySet()) {
                int key = entry.getKey();

                for (int value : entry.getValue()) {
                    if (update.contains(key) && update.contains(value) && update.indexOf(key)
                            > update.indexOf(value)) {
                        rightOrder = false;
                        break;
                    }

                    if (!rightOrder) {
                        break;
                    }
                }
            }

            if (rightOrder) {
                continue;
            }

            update.sort(new Comparator<>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (rules.containsKey(o1) && rules.get(o1).contains(o2)) {
                        return -1;
                    }

                    if (rules.containsKey(o2) && rules.get(o2).contains(o1)) {
                        return 1;
                    }

                    return 0;
                }
            });

            sum += update.get(update.size() / 2);
        }

        System.out.println(sum);
    }
}
