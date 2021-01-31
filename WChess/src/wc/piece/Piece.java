package wc.piece;

import java.util.List;
import wc.board.Board;
import wc.board.Move;

public abstract class Piece {
	
	protected final byte piecePosition;
	protected final Alliance pieceAlliance;
	
	Piece(final byte piecePosition, final Alliance pieceAlliance) {
		this.piecePosition = piecePosition;
		this.pieceAlliance = pieceAlliance;
	}
	
	public abstract List<Move> calculateLegalMoves(final Board board);

	public Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}

}
