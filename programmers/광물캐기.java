package programmers;

import java.util.*;

class Solution_광물캐기 {
    int res = 1000000;
    int[][] p = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    Map<String, Integer> map = new HashMap<>();

    private void func(int[] remainPicks, String[] minerals, int start, int curP) {
        if (start >= minerals.length || (remainPicks[0] == 0 && remainPicks[1] == 0 && remainPicks[2] == 0 )) {
            res = Math.min(curP, res);
            return;
        }


        for (int i = 0; i < 3; i++) {
            if (remainPicks[i] == 0) continue;
            int sum = 0;
            for (int j = start; j < start + 5; j++) {
                if (j >= minerals.length) break;
                sum += p[i][map.get(minerals[j])];
            }
            remainPicks[i] -= 1;
            func(new int[] {remainPicks[0], remainPicks[1], remainPicks[2]}, minerals, start + 5, curP + sum);
            remainPicks[i] += 1;
        }

        return;
    }

    public int solution(int[] picks, String[] minerals) {
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);

        func(picks, minerals, 0, 0);
        return res;
    }
}