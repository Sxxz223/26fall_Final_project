package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红炮

public class CannonPiece extends Piece {
    public CannonPiece(boolean isRed) {
        super("炮", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO：实现炮的移动规则。
        return false;
    }
}
