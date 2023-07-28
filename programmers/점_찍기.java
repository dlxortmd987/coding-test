package programmers;

public class 점_찍기 {
	public long solution(int k, int d) {
		long answer = 0;
		long p = d / k;

		for (long i = 0; i <= p; i++) {
			long x = i*k;
			long t = (long) Math.sqrt((long)d*(long)d - x*x) / k;
			answer += t+1;
		}

		return answer;
	}
}
