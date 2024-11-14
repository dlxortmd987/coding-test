package backjoon.archive;

import java.io.IOException;
import java.util.Scanner;

public class P_1094 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int t = 64;
		int count = 0;

		int n = sc.nextInt();
		while (n > 0) {
			if (t > n)
				t /= 2;
			else {
				count++;
				n -= t;
			}
		}

		System.out.println(count);
	}
}
