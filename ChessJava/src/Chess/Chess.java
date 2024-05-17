package Chess;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Chess 
{
	final static int WIDTH = 720, HEIGH = 640;
	final static float panelPercente = 0.2f;
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("MyChess");
		
		ChessBoard chessBoard = new ChessBoard(8, (int)(HEIGH * (1 - panelPercente)), (int)(HEIGH * (1 - panelPercente)));
		PlayerInfoBoard playerBoard = new PlayerInfoBoard((int)(HEIGH * (1 - panelPercente)), (int)(HEIGH * panelPercente), chessBoard);
		GameInfoBoard gameInfoBoard = new GameInfoBoard((int)(WIDTH - HEIGH * (1 - panelPercente)), HEIGH);
		
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGH));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(gameInfoBoard, BorderLayout.EAST);
		frame.add(playerBoard, BorderLayout.NORTH);
		frame.add(chessBoard, BorderLayout.CENTER);

	}

}
