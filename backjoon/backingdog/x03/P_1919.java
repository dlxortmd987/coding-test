package backjoon.backingdog.x03;

import java.util.Scanner;

public class P_1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        char[] aChars = new char[26];
        char[] bChars = new char[26];
        for (int i = 0; i < a.length(); i++) {
            aChars[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            bChars[b.charAt(i) - 'a']++;
        }

        int l = 0;

        for (int i = 0; i < 26; i++) {
            l += Math.min(aChars[i], bChars[i]);
        }

        System.out.println(a.length() + b.length() - 2 * l);
    }
}