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
        int dr = Math.abs(toRow - fromRow);
        int dc = Math.abs(toCol - fromCol);
        if (!( (dr == 2 && dc == 1) || (dr == 1 && dc == 2) )) {
            return false;
        }
        //判断卡不卡马脚
        
        int stepRow = fromRow;
        int stepCol = fromCol;
        //行变化两格 → 马腿在行方向中间一格，列保持起点不变；列变化两格 → 马腿在列方向中间一格，行保持起点不变。
        if (Math.abs(toRow - fromRow) == 2) {
            stepRow = (toRow + fromRow) / 2;
        } else {
            stepCol = (toCol + fromCol) / 2;
        }

        if (board.getPieceAt(stepRow, stepCol) != null) {
            return false;
        }
        return true;
    }
}
