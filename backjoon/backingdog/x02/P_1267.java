package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class P_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(bf.readLine());
        String[] line = bf.readLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();

        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(line[i]);
            a = (e / 30 + 1) * 10 + a;
            b = (e / 60 + 1) * 15 + b;
        }

        if (a == b) {
            System.out.println("Y M " + a);
        } else if (a < b) {
            System.out.println("Y " + a);
        } else {
            System.out.println("M " + b);
        }
    }
}
