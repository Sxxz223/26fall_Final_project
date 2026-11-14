package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红车

public class ChariotPiece extends Piece {
    public ChariotPiece(boolean isRed) {
        super("车", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO：实现车的移动规则。
        return false;
    }
}
