/**
 * 
 */

/**
 * @author Max (Smugless)
 *
 */
public class TestBoardBuilder {
	
	public static void main(String[] args) {
		BoardBuilder classicalStyleBoard = new ClassicBoardBuilder();
		BoardBuilder largeStyleBoard = new LargeBoardBuilder();
		
		BoardDirector boardDirector1 = new BoardDirector(classicalStyleBoard);
		BoardDirector boardDirector2 = new BoardDirector(largeStyleBoard);

		
		boardDirector1.makeBoard();
		Board firstBoard = boardDirector1.getBoard();
		
		System.out.println("Classic board built!");
		System.out.println("Board width: " +firstBoard.getWidth());
		System.out.println("Board height: " +firstBoard.getHeight());
		
		boardDirector2.makeBoard();
		Board secondBoard = boardDirector2.getBoard();
		
		System.out.println("Large board built!");
		System.out.println("Board width: " +secondBoard.getWidth());
		System.out.println("Board height: " +secondBoard.getHeight());
	}

}
