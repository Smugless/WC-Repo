package wc.piece;

import java.util.ArrayList;
import java.util.List;

import wc.board.Board;
import wc.board.Move;
import wc.board.Square;

public class Knight extends Piece {

	private final static byte[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(byte piecePosition, Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	public List<Move> calculateLegalMoves(Board board) {

		byte candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();

		for (final byte currentCandidate : CANDIDATE_MOVE_COORDINATES) {
			candidateDestinationCoordinate = (byte) (this.piecePosition + currentCandidate);
			if (true /* isValidCoordinate */) {
				final Square candidateDestinationSquare = board.getSquare(candidateDestinationCoordinate);
				if (!candidateDestinationSquare.isSquareOccupied()) {
					legalMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = candidateDestinationSquare.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
				}
			}
		}

		return null;
	}

}
