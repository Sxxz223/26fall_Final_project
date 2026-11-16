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
        if (Math.abs(toRow - fromRow) != 2 || Math.abs(toCol - fromCol) != 2) {
            return false;
        }
        // 检查是否越过河界
        if (isRed()) {
            if (toRow < 5) {
                return false;
            }
        } else {
            if (toRow > 4) {
                return false;
            }
        }
        // 检查是否有棋子阻挡象脚
        int midRow = (fromRow + toRow) / 2;
        int midCol = (fromCol + toCol) / 2;
        if (board.getPieceAt(midRow, midCol) != null) {
            return false;
        }

        return true;
    }
}
