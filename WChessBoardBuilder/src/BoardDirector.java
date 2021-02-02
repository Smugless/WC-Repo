/**
 * 
 */

/**
 * @author Max (Smugless)
 *
 */
public class BoardDirector {
	private BoardBuilder boardBuilder;
	
	public BoardDirector(BoardBuilder boardBuilder) {
		this.boardBuilder = boardBuilder;
	}
	
	public Board getBoard() {
		return this.boardBuilder.getBoard();
	}
	
	public void makeBoard() {
		this.boardBuilder.buildBoardWidth();
		this.boardBuilder.buildBoardHeight();
		this.boardBuilder.buildNumSquares();
	}
}
