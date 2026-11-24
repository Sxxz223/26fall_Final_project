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
        //兵一次只能走一步
        if (Math.abs(toRow - fromRow) + Math.abs(toCol - fromCol) != 1) {
            return false;
        }
        //士兵永不后退,越过楚河汉界才可以拐弯
        if (isRed()){
            if (toRow - fromRow > 0){
                return false;
            }
            if (fromRow > 4 && fromCol != toCol){
                return false;
            }
        }
        else{
            if (toRow - fromRow < 0){
                return false;
            }
            if (fromRow < 5 && fromCol != toCol){
                return false;
            }
        }
        return true;
    }
}
