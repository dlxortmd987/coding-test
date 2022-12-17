package programmers;

import java.util.*;

public class 더_맵게 {


    public int solution(int[] scoville, int k) {
        int answer = 0;

        /**
         * 1. 가장 작은거 2개를 고름
         * 2. 섞은 후 배열에 넣음
         * 3. 배열 정렬
         * 4. 모든 음식이 k 보다 큰지 판별
         */
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville) {
            q.add(i);
        }

        while (q.size() > 1 && q.peek() < k) {
            int first = q.poll();
            int second = q.poll();
            int num = first + second * 2;
            q.add(num);
            answer++;
        }

        if (q.peek() < k)
            return -1;

        return answer;
    }

}