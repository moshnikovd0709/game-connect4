public class BoardConfiguration {
	public int boardSizeWidth = 7;
	public int boardSizeHeigh = 6;
	private int endGame = 4;
	private int[][] board = new int[boardSizeWidth][boardSizeHeigh];
	private int[] columnSize = new int[boardSizeWidth];
	private int z = boardSizeWidth * boardSizeHeigh;

	public boolean checkMove(int column) {
		column--;
		if ((column < boardSizeWidth) && (columnSize[column] < boardSizeHeigh)) {
			return true;
		} else {
			return false;
		}
	}

	public void makeMove(int column, boolean player) {
		column--;
		if (board[column][columnSize[column]] == 0) {
			if (!player) {
				board[column][columnSize[column]] = 1;
			} else {
				board[column][columnSize[column]] = 2;
			}
			z--;
			columnSize[column]++;
		}
	}

	public void showBoard() {
		for (int i = boardSizeHeigh - 1; i >= 0; i--) {
			for (int j = 0; j < boardSizeWidth; j++) {
				if (board[j][i] == 0) {
					System.out.print(". ");
				} else if (board[j][i] == 1) {
					System.out.print("x ");
				} else {
					System.out.print("o ");
				}
			}
			System.out.println();
		}
	}

	public boolean endGame(int column, boolean turnSecondPlayer) {
		column--;
		int number = columnSize[column] - 1;
		int counter = -1;
		int i = column;
		int j = number;
		int check = 2;
		if (z == 0) {
			System.out.println("Draw");
			return true;
		}
		if (!turnSecondPlayer) {
			check = 1;
		}
		while (i < boardSizeWidth && board[i][j] == check) {
			counter++;
			i++;
		}
		i = column;
		while (i >= 0 && board[i][j] == check) {
			counter++;
			i--;
		}
		if (counter >= endGame) {
			if (check == 2) {
				System.out.println("Second player win!");
				} else {
					System.out.println("First player win!");
				}
			return true;
		}
		counter = -1;
		i = column;
		j = number;
		while (j < boardSizeHeigh && board[i][j] == check) {
			counter++;
			j++;
		}
		j = number;
		while (j >= 0 && board[i][j] == check) {
			counter++;
			j--;
		}
		if (counter >= endGame) {
			if (check == 2) {
				System.out.println("Second player win!");
				} else {
					System.out.println("First player win!");
				}
			return true;
		}
		counter = -1;
		i = column;
		j = number;
		while (i < boardSizeWidth && j < boardSizeHeigh && board[i][j] == check) {
			counter++;
			j++;
			i++;
		}
		j = number;
		i = column;
		while (i >= 0 && j >= 0 && board[i][j] == check) {
			counter++;
			j--;
			i--;
		}
		if (counter >= endGame) {
			if (check == 2) {
				System.out.println("Second player win!");
				} else {
					System.out.println("First player win!");
				}
			return true;
		}
		counter = -1;
		i = column;
		j = number;
		while (i < boardSizeWidth && j >= 0 && board[i][j] == check) {
			counter++;
			j--;
			i++;
		}
		j = number;
		i = column;
		while (i >= 0 && j < boardSizeHeigh && board[i][j] == check) {
			counter++;
			j++;
			i--;
		}
		if (counter >= endGame) {
			if (check == 2) {
			System.out.println("Second player win!");
			} else {
				System.out.println("First player win!");
			}
			return true;
		}
		return false;
	}
}
