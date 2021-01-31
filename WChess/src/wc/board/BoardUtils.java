package wc.board;

public class BoardUtils {

	public static boolean isValidSquareCoordinate(byte coordinate) {
		return coordinate>=0 && coordinate < 64;
	}

}
