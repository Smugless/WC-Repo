/**
 * 
 */

/**
 * @author Max (Smugless)
 *
 */
public class ClassicBoardBuilder implements BoardBuilder {

	private Board board;
	private static final int WIDTH = 8;
	private static final int HEIGHT = 8;
	
	public ClassicBoardBuilder() {
		this.board = new Board();
	}
	
	@Override
	public void buildBoardWidth() {
		board.setWidth(WIDTH);
	}

	@Override
	public void buildBoardHeight() {
		board.setHeight(HEIGHT);
	}

	@Override
	public void buildNumSquares() {
		 board.setNumSquares(WIDTH*HEIGHT);
	}
	
	@Override
	public Board getBoard() {
		return this.board;
	}
}
