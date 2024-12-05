package backjoon.backingdog.x03;

import java.util.Scanner;

public class P_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        int[] arr = new int[9];

        for (int i = 0; i < n.length(); i++) {
            int idx = n.charAt(i) - '0';
            if (idx == 9) idx = 6;
            arr[idx]++;
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, i == 6 ? Math.round((float) arr[i] / 2) : arr[i]);
        }
        System.out.println(max);
    }
}
