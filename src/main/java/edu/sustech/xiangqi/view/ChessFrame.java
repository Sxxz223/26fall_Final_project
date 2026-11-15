package edu.sustech.xiangqi.view;

import edu.sustech.xiangqi.model.Board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;

public final class ChessFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final BoardPanel boardPanel;

    public ChessFrame(Board board) {
        super("中国象棋");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardPanel = new BoardPanel(board);
        //实现窗口居中：GridBagLayout 是布局管理器
        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(new Color(239, 218, 179));
        container.add(boardPanel);
        //测试按钮
        JButton button = new JButton("Click");
        button.setBounds(500, 10, 80, 30);  // x, y, width, height
        boardPanel.add(button);
        JLabel label=new JLabel("Sample");
        label.setBounds(600, 10, 80, 30);

        boardPanel.add(label);
        button.addActionListener(e->{
            label.setText("Click");
        });
        setContentPane(container);
        setSize(1000, 1000);
        setMinimumSize(new Dimension(750, 850));//限制窗口最小尺寸
        setLocationRelativeTo(null);
        //允许调整窗口大小
        setResizable(true);
        setLocationRelativeTo(null);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }
}
