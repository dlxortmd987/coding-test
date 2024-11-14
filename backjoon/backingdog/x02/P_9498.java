package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class P_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        String line = bf.readLine();
        int a = Integer.parseInt(line);
        if (90 <= a && a <= 100) {
            System.out.println("A");
        } else if (80 <= a) {
            System.out.println("B");
        } else if (70 <= a) {
            System.out.println("C");
        } else if (60 <= a) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
