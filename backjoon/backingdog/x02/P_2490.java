package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] line = bf.readLine().split(" ");
            int zeroCount = 0;
            for (int j = 0; j < 4; j++) {
                if ("0".equals(line[j])) {
                    zeroCount++;
                }
            }

            switch (zeroCount) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
            }
        }


    }
}
