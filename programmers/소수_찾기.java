package programmers;

import java.util.*;

public class 소수_찾기 {
    HashSet<Integer> hashSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        permutation("", numbers);
        for (Integer num : hashSet) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    private boolean isPrime(Integer num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void permutation(String prefix, String str) {
        int n = str.length();
        if (!prefix.equals(""))
            hashSet.add(Integer.parseInt(prefix));
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
