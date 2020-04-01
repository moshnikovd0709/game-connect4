import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {
	
	protected int makeMovePlayer(BoardConfiguration bc) {
		Random rnd = new Random(System.currentTimeMillis());
		int number = 1 + rnd.nextInt(bc.boardSizeWidth); // ������ � ��������� ��������
		System.out.println(number);
		return number;
	}
	
}
