import java.io.*;
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        int n = Integer.parseInt(sArr[0]);
        int r = Integer.parseInt(sArr[1]);
        int c = Integer.parseInt(sArr[2]);

        int a = (int) Math.pow(2, n);

        int count = 0;
        int retR = a/2;
        int retC = a/2;
        while (true) {
            if (a == 1) break;
            if (c < retC && r < retR) {
                retR -= a/4;
                retC -= a/4;
            } else if (c >= retC && r < retR) {
                count += (a*a/4);
                retR -= a/4;
                retC += a/4;
            } else if (c < retC && r >= retR) {
                count += (a*a/4) * 2;
                retR += a/4;
                retC -= a/4;
            } else if (c >= retC && r >= retR) {
                count += (a*a/4) * 3;
                retR += a/4;
                retC += a/4;
            }
            a /= 2;
        }

        System.out.println(count);
        br.close();

    }

}

