package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红兵

public class SoldierPiece extends Piece {
    public SoldierPiece(boolean isRed) {
       super(isRed ? "兵" : "卒", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO：实现兵的移动规则。
        return false;
    }
}
