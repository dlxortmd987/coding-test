package backjoon.backingdog.x06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(n + 1);
        }

        while (q.size() > 1) {

        }
    }
}
