package backjoon.backingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            char[] originChars = new char[26];
            char[] arrangeChars = new char[26];
            String origin = line[0];
            String arrange = line[1];

            if (origin.length() != arrange.length()) {
                System.out.println("Impossible");
                continue;
            }

            for (int j = 0; j < origin.length(); j++) {
                originChars[origin.charAt(j) - 'a']++;
                arrangeChars[arrange.charAt(j) - 'a']++;
            }

            if (isPossible(originChars, arrangeChars)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    private static boolean isPossible(char[] originChars, char[] arrangeChars) {
        for (int j = 0; j < 26; j++) {
            if (originChars[j] != arrangeChars[j]) {
                return false;
            }
        }
        return true;
    }
}