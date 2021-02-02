package wc.board;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import wc.piece.Piece;

/**
 * 
 * @author Max (Smugless)
 * 
 * Very Heavily influenced by amir.afghani's code and youtube series here:https://youtu.be/h8fSdSUKttk
 */

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
		
		final Map<Byte, EmptySquare> emptySquareMap = new HashMap<Byte, EmptySquare>();
		
		for(byte i = 0; i < BoardUtils.NUM_SQUARES; i++) {
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