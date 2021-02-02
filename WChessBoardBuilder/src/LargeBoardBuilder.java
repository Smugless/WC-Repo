/**
 * 
 */

/**
 * @author Max (Smugless)
 *
 */
public class LargeBoardBuilder implements BoardBuilder {
	
	private Board board;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 12;
	
	public LargeBoardBuilder() {
		this.board = new Board();
	}
	
	@Override
	public void buildBoardWidth() {
		this.board.setWidth(WIDTH);
	}

	@Override
	public void buildBoardHeight() {
		this.board.setHeight(HEIGHT);
	}

	@Override
	public void buildNumSquares() {
		this.board.setNumSquares(WIDTH*HEIGHT);
	}

	@Override
	public Board getBoard() {
		return this.board;
	}

}
