package edu.sustech.xiangqi.model.Pieces;

import edu.sustech.xiangqi.model.Board;
import edu.sustech.xiangqi.model.Piece;

// 红帅

public class GeneralPiece extends Piece {
    public GeneralPiece(boolean isRed) {
        super(isRed ? "帅" : "将", isRed);
    }

    @Override
    public boolean canMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        // 行和列必须都变化一格，不能斜走、原地停留或跨越多格
        // 到目标点的绝对距离小于1
        if (Math.abs(toRow - fromRow) + Math.abs(toCol - fromCol) != 1) {
            return false;
        }
        // 列判断
        if (toCol < 3 || toCol > 5) {
            return false;
        }
        // 行判断
        if (isRed()) {
            return toRow >= 7 && toRow <= 9;
        } else {
            return toRow >= 0 && toRow <= 2;
        }
    }
}
