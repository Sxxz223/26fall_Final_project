package edu.sustech.xiangqi.model;

// 保存棋盘数据，并统一检查和执行移动

public class Board {
    // 定义棋盘大小
    public static final int ROWS = 10;
    public static final int COLS = 9;
    private boolean turn = true;//判断回合

    // 存储棋子位置
    private final Piece[][] pieces = new Piece[ROWS][COLS];
    
    //构造方法
    public Board() {
        initializePieces();
    }
    
    //摆放棋子的位置
    private void initializePieces() {
        pieces[9][3] = new AdvisorPiece();
        pieces[9][4] = new GeneralPiece();
        pieces[9][5] = new AdvisorPiece();
    }

    //判断棋子是否出界
    public boolean isInside(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    //获取传入坐标对应的棋子实例
    public Piece getPieceAt(int row, int col) {
        if (!isInside(row, col)) {
            return null;
        }
        return pieces[row][col];
    }

    //
    public boolean tryMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isInside(fromRow, fromCol) || !isInside(toRow, toCol)) {
            return false;
        }
        if (fromRow == toRow && fromCol == toCol) {
            return false;
        }

        Piece piece = getPieceAt(fromRow, fromCol);
        if (piece == null) {
            return false;
        }

        // TODO: 加入回合检查，只允许当前一方移动自己的棋子(完成)
        if (piece.isRed() != turn){
            return false;
        }

        // TODO: 区分己方占用与敌方棋子，并实现吃子(完成)
        if (getPieceAt(toRow, toCol).isRed() == turn ) {
            return false;
        }

        if (isInside(toRow, toCol) == false){
            return false;
        }

        if (!piece.canMove(this, fromRow, fromCol, toRow, toCol)) {
            return false;
        }

        // TODO: 检查走完后己方将帅是否安全
        pieces[fromRow][fromCol] = null;
        pieces[toRow][toCol] = piece;

        // TODO: 仅在成功移动后切换回合（完成），并判断将军、胜负等状态
        
        turn = !turn;

        return true;
    }
}
