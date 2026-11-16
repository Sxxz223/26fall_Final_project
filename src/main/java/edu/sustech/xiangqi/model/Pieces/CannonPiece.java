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
        if (fromRow != toRow && fromCol != toCol) {
            return false;
        }
        if (fromRow == toRow) {
            //判断是往前还是往后
            int step = (toCol - fromCol) > 0 ? 1 : -1;
            int num = 0;
            for (int col = fromCol + step; col != toCol; col += step) {
                //一一判断该行上是否有棋子阻挡
                if (board.getPieceAt(fromRow, col) != null) {
                    num++;
                }
            }
            if (board.getPieceAt(toRow, toCol) != null && num != 1) {
                return false;
            }
            if (board.getPieceAt(toRow, toCol) == null && num != 0){
                return false;
            }
            
        } else {
            //判断是往前还是往后
            int step = (toRow - fromRow) > 0 ? 1 : - 1;
            int num = 0;
            for (int row = fromRow + step; row != toRow; row += step) {
                //一一判断该列上是否有棋子阻挡
                if (board.getPieceAt(row, fromCol) != null) {
                    num++;
                }
            }
            if (board.getPieceAt(toRow, toCol) != null && num != 1) {
                return false;
            }
            if (board.getPieceAt(toRow, toCol) == null && num != 0){
                return false;
            }
        }   
        return true;
    }
}
