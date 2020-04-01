public class GameServer {
		private Player player1; // false
		private Player player2; // true
		private BoardConfiguration bc;
		private int turn;
		
		GameServer(Player p1, Player p2) {
			player1 = p1;
			player2 = p2;
			bc = new BoardConfiguration();
			turn = 0;
		}
		
		void start() {
			bc.showBoard();
			nextMove();
		}
		
		private void nextMove() {
			int stack;
			boolean playerTurn;
			if (turn % 2 == 0) {
				playerTurn = false;
				stack = getMove(player1);
			} else {
				playerTurn = true;
				stack = getMove(player2);
			}
			bc.makeMove(stack, playerTurn);
			if (bc.endGame(stack, playerTurn)) {
				exit();
			} else {
				System.out.println("Next move");
				turn++;
				bc.showBoard();
				nextMove();
			}
		}
		
		private void exit() {
			bc.showBoard();
		}
		
		
		private int getMove(Player p) {
			int stack = p.makeMove(bc);
			while (!bc.checkMove(stack)) {
				System.out.println("Invalid move");
				stack = p.makeMove(bc);
			}
			return stack;
		}
		
		public static void main(String[] args) {
			Player player1 = new HumanPlayer();
			Player player2 = new HumanPlayer();
			GameServer server = new GameServer(player1, player2);
			server.start();
		}
	}
