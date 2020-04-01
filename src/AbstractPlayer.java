public abstract class AbstractPlayer implements Player {
	
	protected abstract int makeMovePlayer(BoardConfiguration bc);
	
	public int makeMove(BoardConfiguration bc) {
		return makeMovePlayer(bc);
	}
		
}
