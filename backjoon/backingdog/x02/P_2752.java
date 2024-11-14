package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] line = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Arrays.sort(line);

        System.out.println(line[0] + " " + line[1] + " " + line[2]);
    }
}
