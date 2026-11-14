package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红相

public class ElephantPiece extends Piece {
    public  ElephantPiece(boolean isRed) {
        super(isRed ? "相" : "象", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO：实现相的移动规则。
        return false;
    }
}
