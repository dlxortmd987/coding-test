package backjoon.backingdog.x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class P_1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        String[] line = bf.readLine().split(" ");
        System.out.println(Integer.parseInt(line[0]) + Integer.parseInt(line[1]));
    }
}
