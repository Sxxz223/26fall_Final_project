package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红马

public class HorsePiece extends Piece {
    public HorsePiece(boolean isRed) {
        super("马", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO：实现马的移动规则。
        return false;
    }
}
