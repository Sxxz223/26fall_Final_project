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
        // 车可以直走，不能斜走
        if (fromRow != toRow && fromCol != toCol) {
            return false;
        }
        // 检查路径上是否有其他棋子阻挡
        // 判断是在列上还是行上移动
        if (fromRow == toRow) {
            //判断是往前还是往后
            int step = (toCol - fromCol) > 0 ? 1 : -1;
            for (int col = fromCol + step; col != toCol; col += step) {
                //一一判断该行上是否有棋子阻挡
                if (board.getPieceAt(fromRow, col) != null) {
                    return false;
                }
            }
        } else {
            //判断是往前还是往后
            int step = (toRow - fromRow) > 0 ? 1 : - 1;
            for (int row = fromRow + step; row != toRow; row += step) {
                //一一判断该列上是否有棋子阻挡
                if (board.getPieceAt(row, fromCol) != null) {
                    return false;
                }
            }
        }   
        return true;
    }
}
