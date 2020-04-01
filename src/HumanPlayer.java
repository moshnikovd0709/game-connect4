import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
	
	protected int makeMovePlayer(BoardConfiguration bc) {
		Scanner in = new Scanner(System.in);
		int move = in.nextInt();
		return move;
	}

}
