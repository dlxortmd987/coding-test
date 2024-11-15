package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int e = Integer.parseInt(bf.readLine());
            arr.add(e);
            sum += e;
        }

        Collections.sort(arr);

        List<Integer> result = getList(arr, sum);

        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static List<Integer> getList(List<Integer> arr, int sum) {
        List<Integer> result = new ArrayList<>(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr.get(i) - arr.get(j) == 100) {
                    result.remove(j);
                    result.remove(i);
                    return result;
                }
            }
        }
        return result;
    }
}
