package gitTheAlgos.algos;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static ArrayList<String> allOfLen(ArrayList<String> data, int r) {
        /*
        ArrayList<ArrayList<String>> combs = new ArrayList<>();
        combs.add(new ArrayList<>());
        find(combs, r, r, data, 0);
        combs.remove(combs.size() - 1);
        */
        if (r <= 0) {
            return new ArrayList<>();
        }
        ArrayList<String> combs = find(data, 0, r);

        return combs;
    }

    private static ArrayList<String> find(ArrayList<String> data, int index, int r){
        if (r == 1) {
            ArrayList<String> combs = new ArrayList<>();
            for (int i = index; i < data.size(); i++) {
                combs.add(data.get(i));
            }
            return combs;
        }

        ArrayList<String> combs = new ArrayList<>();
        for (int i = index; i < (data.size() - r + 1); i++) {
            ArrayList<String> retCombs = find(data, i + 1, r - 1);
            for (int j = 0; j < retCombs.size(); j++)  {
                combs.add(data.get(i)+","+retCombs.get(j));
            }
        }
        return combs;
    }

    /**
     * Baeldung version.
     * https://www.baeldung.com/java-combinations-algorithm
     */
    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }

    /**
     * First attempt. doesn't work
     */
    private static void find(ArrayList<ArrayList<String>> combs, int r, int k, ArrayList<String> data, int i) {
        if(k == 0) {
            return;
        }
        for (int j = i; j < data.size() && j < (r - 1 + i); j++) {
            combs.get(combs.size() - 1).add(data.get(j));
            find(combs, r, k-1, data, j+1);
            if ((j+1) < Math.min(data.size(), (r - 1 + i))) {
                ArrayList<String> prevList = combs.get(combs.size() - 1);
                combs.add(new ArrayList<>());
                for (int l = 0; l < i; l++) {
                    combs.get(combs.size() - 1).add(prevList.get(l));
                }
            }
        }
    }
}
