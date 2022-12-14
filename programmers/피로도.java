package programmers;

import java.util.Arrays;

public class 피로도 {

    int size;
    boolean[] visited;
    int curK;
    int oriK;
    int count;
    int max = 0;

    public void per(int[][] arr, int[][] output, int d) {
        if (d == size) {
            for (int i = 0; i < size; i++) {
                int min = output[i][0];
                int con = output[i][1];

                if (curK >= min) {
                    count++;
                    curK -= con;
                }
            }
            if (max < count) {
                max = count;
            }
            curK = oriK;
            count = 0;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[d] = arr[i];
                per(arr, output, d+1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        count = 0;
        curK = k;
        oriK = k;
        size = dungeons.length;
        visited = new boolean[size];
        int[][] output = new int[size][2];

        per(dungeons, output, 0);

        return max;
    }
}
