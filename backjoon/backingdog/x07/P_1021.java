package backjoon.backingdog.x07;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int s = 0;
        List<Integer> arr = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int idx = 0;
            int num = arr.get(0);
            while (num != t) {
                idx++;
                if (idx >= arr.size())
                    break;
                num = arr.get(idx);
            }
            int l = idx;
            int r = arr.size() - idx;

            if (l > r) {
                res += r;
                while (r > 0) {
                    arr.add(0, arr.get(arr.size() - 1));
                    arr.remove(arr.size() - 1);
                    r--;
                }
            } else {
                res += l;
                while (l > 0) {
                    arr.add(arr.get(0));
                    arr.remove(0);
                    l--;
                }
            }
            arr.remove(0);
        }

        System.out.println(res);
    }
}
