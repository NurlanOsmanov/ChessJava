package Chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoBoard extends JPanel
{
	private int panelWidth, panelHeigh;
	
	private Font nameFont;
	private Image WhiteProfilePhoto;
	private Image BlackProfilePhoto;
	
	private boolean sideChanger;
	
	ChessBoard chessBoard;
	Game game;
	public PlayerInfoBoard(int panelWidth, int panelHeigh, ChessBoard chessBoard) 
	{
		this.chessBoard = chessBoard;
		game = chessBoard.getGame();
		nameFont = new Font("Fixedsys Normal", Font.BOLD, 30);
		
		this.panelHeigh = panelHeigh;
		this.panelWidth = panelWidth;
		
		try {
			WhiteProfilePhoto = new ImageIcon(getClass().getResource("WhiteKnight.png")).getImage();
		} catch (Exception e) {
			System.out.println("WhitePP not found");
		}
		
		try {
			BlackProfilePhoto = new ImageIcon(getClass().getResource("BlackKnight.png")).getImage();
		} catch (Exception e) {
			System.out.println("BlackPP not found");
		}
		
		setPreferredSize(new Dimension(panelWidth, panelHeigh));
		setBackground(new Color(120, 120, 120));
		setLayout(null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawRect(1, 1, panelWidth - 1, panelHeigh - 2);	
		g2d.fillRect(panelWidth/2 - 2, 1, 4, panelHeigh - 2);
		
		WhiteProfile(g2d, 3, 3);
		BlackProfile(g2d, 3 + panelWidth/2 + 4, 3);
		
		SideSelector(0, 0, panelWidth, panelHeigh);
		
		repaint();
	}
	
	public void WhiteProfile(Graphics2D g2d, int x, int y)
	{
		g2d.setColor(new Color(75, 75, 75));
		g2d.fillRect(x, y, panelHeigh - 46, panelHeigh - 46);
		g2d.setColor(new Color(25, 25, 25));
		g2d.fillRect(x + 2, y + 2, panelHeigh - 50, panelHeigh - 50);
		g2d.drawImage(WhiteProfilePhoto, x - 3, y -3, panelHeigh -40, panelHeigh - 40, null);
		
		g2d.setColor(Color.white);
		g2d.setFont(nameFont);
		g2d.drawString("Player 1", x +  panelHeigh - 40, y + panelHeigh/4);
		
		if(!chessBoard.isChessSideChanger())
		{
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(new Color(250, 250, 0));
			g2d.drawRect(x - 1, y - 2, panelWidth/2 - 4, panelHeigh - 2);
			if(game.isCheckToWhite())
			{
				g2d.setColor(new Color(230, 0, 0));
				g2d.drawRect(x, y - 1, panelWidth/2 - 6, panelHeigh - 4);
			}
		}
		
	}
	
	public void BlackProfile(Graphics2D g2d, int x, int y)
	{
		g2d.setColor(new Color(150, 150, 150));
		g2d.fillRect(x, y, panelHeigh - 46, panelHeigh - 46);
		g2d.setColor(new Color(230, 230, 230));
		g2d.fillRect(x + 2,y + 2, panelHeigh - 50, panelHeigh - 50);
		g2d.drawImage(BlackProfilePhoto, x - 3, y - 3, panelHeigh -40, panelHeigh - 40, null);
		
		g2d.setColor(Color.white);
		g2d.setFont(nameFont);
		g2d.drawString("Player 2", x +  panelHeigh - 40, y + panelHeigh/4);
		
		if(chessBoard.isChessSideChanger())
		{
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(new Color(250, 250, 0));
			g2d.drawRect(x - 6, y - 2, panelWidth/2 - 1, panelHeigh-2);
			if(game.isCheckToBlack())
			{
				g2d.setColor(new Color(230, 0, 0));
				g2d.drawRect(x - 5, y - 1, panelWidth/2 - 3, panelHeigh - 4);
			}

		}
	}
	
	public void SideSelector(int x1, int y1, int x2, int y2)
	{
		if(sideChanger) System.out.println("->>-->> "+sideChanger);
	}
	
	//----
	
	public void setSideChanger(boolean sideChanger) {
		this.sideChanger = sideChanger;
	}
}
