package programmers;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */

public class 네트워크 {
    int[][] g;
    boolean[] visited;
    int size;

    public void dfs(int n) {
        visited[n] = true;

        for (int i = 0; i < size; i++) {

            if (g[n][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        g = computers;
        visited = new boolean[n];
        size = n;


        for (int i = 0; i < n; i++) {
            System.out.println(visited[i]);
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}
