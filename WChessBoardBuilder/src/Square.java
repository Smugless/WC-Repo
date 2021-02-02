
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import wc.piece.Piece;

/**
 * 
 * @author Max (Smugless)
 * 
 *         Very Heavily influenced by amir.afghani's code and youtube series
 *         here:https://youtu.be/h8fSdSUKttk
 */

public abstract class Square {

	// The square coordinate as an integer. I use one coordinate (which will be any
	// value up to 64 on a regular 8x8 board) rather than two because it's easier to
	// implement the pieces that way, and the code will be more performant.
	private final int squareCoordinate;

	// A cache of all possible empty squares, so we do not need to allocate new
	// memory every time a square is made empty.
	// I need it to be static so that it's the same for all squares on a given board
	// and I want it to be final since it won't change
	private static final Map<Integer, EmptySquare> EMPTY_SQUARES_CACHE = createAllPossibleEmptySquares();

	public static Square createSquare(final int squareCoordinate, final Piece piece) {

		return piece != null ? new OccupiedSquare(squareCoordinate, piece) : EMPTY_SQUARES_CACHE.get(squareCoordinate);
	}

	private Square(final int squareCoordinate) {
		this.squareCoordinate = squareCoordinate;
	}

	// Creates a Map of all of the possible empty squares
	private static Map<Integer, EmptySquare> createAllPossibleEmptySquares() {
		final Map<Integer, EmptySquare> emptySquareMap = new HashMap<Integer, EmptySquare>();

		for (int i = 0; i < /*
								 * This is my problem, I want to put some form of Board.getNumSquares() in here,
								 * to allow for non-standard board sizes
								 */; i++) {
			emptySquareMap.put(i, new EmptySquare(i));
		}

		return ImmutableMap.copyOf(emptySquareMap);
	}

	public abstract boolean isSquareOccupied();

	public abstract Piece getPiece();

	public static final class EmptySquare extends Square {

		private EmptySquare(int squareCoordinate) {
			super(squareCoordinate);
		}

		@Override
		public boolean isSquareOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}
	}

	public static final class OccupiedSquare extends Square {

		private final Piece pieceOnSquare;

		private OccupiedSquare(int squareCoordinate, Piece pieceOnSquare) {
			super(squareCoordinate);
			this.pieceOnSquare = pieceOnSquare;
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean isSquareOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return pieceOnSquare;
		}

	}
}