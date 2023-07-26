package programmers;

public class 혼자서_하는_틱택토 {
	public static boolean isWon(char target, String[] board) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == target && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2))
				return true;
			if (board[0].charAt(i) == target && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i))
				return true;
		}

		if (board[0].charAt(0) == target && board[1].charAt(1) == board[0].charAt(0) && board[1].charAt(1) == board[2].charAt(2))
			return true;
		if (board[0].charAt(2) == target && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))
			return true;

		return false;
	}

	public static int solution(String[] board) {
		int os = 0;
		int xs = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'O') os++;
				else if (board[i].charAt(j) == 'X') xs++;
			}
		}

		boolean xw = isWon('X', board);
		boolean ow = isWon('O', board);

		if (xs > os || os - xs > 1)
			return 0;

		if (ow && xw)
			return 0;

		if (ow && os != xs + 1)
			return 0;

		if (xw && os != xs)
			return 0;


		return 1;
	}

	public static void main(String[] args) {
		String[] b1 = {"O.X", ".O.", "..X"};
		String[] b2 = {"OOO", "...", "XXX"};
		String[] b3 = {"...", ".X.", "..."};
		String[] b4 = {"...", "...", "..."};

		solution(b1);
		solution(b2);
		solution(b3);
		solution(b4);
	}
}
