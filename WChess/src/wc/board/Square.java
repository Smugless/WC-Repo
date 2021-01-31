package wc.board;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import wc.piece.Piece;

public abstract class Square {
	
	private final byte squareCoordinate;
	
	private static final Map<Byte, EmptySquare> EMPTY_SQUARES_CACHE = createAllPossibleEmptySquares();
	
	public static Square createSquare(final byte squareCoordinate, final Piece piece) {
		
		return piece != null ? new OccupiedSquare(squareCoordinate, piece) : EMPTY_SQUARES_CACHE.get(squareCoordinate);
	}
	
	private Square(final byte squareCoordinate) {
		this.squareCoordinate = squareCoordinate;
	}
	
	private static Map<Byte, EmptySquare> createAllPossibleEmptySquares() {
		
		final Map<Byte, EmptySquare> emptySquareMap = new HashMap();
		
		for(byte i = 0; i < 64; i++) {
			emptySquareMap.put(i, new EmptySquare(i));
		}
		
		return ImmutableMap.copyOf(emptySquareMap);
	}

	public abstract boolean isSquareOccupied();
	
	public abstract Piece getPiece();
	
	
	public static final class EmptySquare extends Square {
		
		private EmptySquare(byte squareCoordinate) {
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

		private OccupiedSquare(byte squareCoordinate, Piece pieceOnSquare) {
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