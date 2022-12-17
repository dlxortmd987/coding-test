package programmers;

public class 모음사전 {


    public int solution(String word) {
        int answer = 0;

        /*
        1번째 -> +(156*5+1)=+781
        2번째 -> +(31*5+1)=+156
        3번째 -> +(6*5+1)=+31
        4번째 -> +6
        5번째 -> +1
         */
        int[] x = {781, 156, 31, 6, 1};
        String str = "AEIOU";

        int idx;
        answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            idx = str.indexOf(word.charAt(i));
            answer += x[i]*idx;
        }

        return answer;
    }

}
