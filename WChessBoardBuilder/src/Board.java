import java.util.List;

/**
 * @author Max (Smugless)
 *
 */
public class Board implements BoardPlan {
	
	private int boardWidth;
	private int boardHeight;
	private int numSquares;
	
	//TODO add private final List<Square> gameBoard;

	@Override
	public void setWidth(int width) {
		if(width > 0)
			this.boardWidth = width;
		else 
			throw new RuntimeException("You may not set a width less than 1!");
	}

	public int getWidth() {
		return this.boardWidth;
	}


	@Override
	public void setHeight(int height) {
		if(height > 0)
			this.boardHeight = height;
		else 
			throw new RuntimeException("You may not set a height less than 1!");	}
	
	public int getHeight() {
		return this.boardHeight;
	}

	@Override
	public void setNumSquares(int numSquares) {
		this.numSquares = numSquares;
	}
	
	public int getNumSquares() {
		return numSquares;
	}
}
