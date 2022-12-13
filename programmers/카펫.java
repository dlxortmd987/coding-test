package programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {

        // 가로 개수 -> w, 세로 개수 -> h, w >= h
        // 브라운 카펫 개수 -> 2 * w + 2 * (h - 2) = brown
        // w = (brown - 2 * (h - 2)) / 2
        // yellow = w * h - brown = w * h - 2 * w - 2 * (h - 2)

        // h >= 3, w >= 3
        int w = 3;
        int h = 3;
        boolean flag = true;
        while (flag) {
            if (w * h == (brown + yellow)) {
                if (brown == 2 * (w + h - 2)) {
                    flag = false;
                } else {
                    h++;
                    w = h;
                }
            } else if (w * h > (brown + yellow)){
                h++;
                w = h;
            } else {
                w++;
            }
        }
        int[] answer = {w, h};

        return answer;
    }
}
