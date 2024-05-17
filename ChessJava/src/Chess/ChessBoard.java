package Chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ChessBoard extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private int chessBoardCount, panelWidth, panelHeigh;
	
	private Rectangle[][] chessBoard;
	
	private boolean[][] chessBoardSquare;
	
	private int piecesMatrix[][];
	
	private boolean chessSideChanger;
	Pieces pieces;
	private int chessBoardSize;
	
	private Game game;
	
	public ChessBoard(int n, int panelWidth, int panelHeigh)
	{
		chessBoardSize = panelWidth / n;
		 
		pieces = new Pieces(n);
		
		game = new Game(n, pieces.getPiecesMatrix(), pieces);
		
		game.setSideChanged(chessSideChanger);
		
		piecesMatrix = pieces.getPiecesMatrix();
		chessSideChanger = pieces.isChessSideChanger();

			
		this.chessBoardCount = n;
		
		chessBoardSquare = new boolean[chessBoardCount][chessBoardCount];
		chessBoard = new Rectangle[chessBoardCount][chessBoardCount];
		
		this.panelWidth = panelWidth;
		this.panelHeigh = panelHeigh;
		
		add(pieces);
		
		setPreferredSize(new Dimension(panelWidth,panelHeigh));
		setBackground(new Color(150,150,150));
		setLayout(null);
		
		Square();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		ChessBoardGenerator(g2d, chessBoardCount);
		
		ChessPieces(g2d);
		repaint();
	}
	
	//--------------------------------
	
	Color SquareColor = new Color(60,50,50);
	public void ChessBoardGenerator(Graphics2D g2d,int chessBoardCount)
	{
		for (int i = 0; i < chessBoardCount; i++) {
			for (int j = 0; j < chessBoardCount; j++) {
				if((j + i) % 2 == 0)
				{
					g2d.setColor(new Color(SquareColor.getRed() + 140,SquareColor.getGreen() + 150,SquareColor.getBlue() + 150));
					SelectedSquareColor(g2d, new Color(200,200,0), i, j);
				}
				else 
				{
					g2d.setColor(new Color(SquareColor.getRed(),SquareColor.getGreen(),SquareColor.getBlue()));
					SelectedSquareColor(g2d, new Color(150,150,0), i, j);
				}
				
				
				g2d.fill(chessBoard[i][j]);
			}
		}
	}
	
	public void Square()
	{
		int chessBoardSize = panelWidth / chessBoardCount;
		for (int i = 0; i < chessBoardCount; i++) {
			for (int j = 0; j < chessBoardCount; j++) {
				chessBoard[i][j] = new Rectangle();
				chessBoard[i][j].setBounds(j * chessBoardSize,i * chessBoardSize,chessBoardSize,chessBoardSize);
			}
		}
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseClicked(e);			
				for (int i = 0; i < chessBoardCount; i++) {
					for (int j = 0; j < chessBoardCount; j++) {
						if(chessBoard[i][j].contains(getMousePosition()))
						{
							//SquareMatrix(i,j);
							SelectedSquare(i,j);
						}
					}
				}
			}
		});
	}
	
	
	
	public void SquareMatrix(int x, int y)
	{
		System.out.println("-->1. " + preX + " - " + preY);
		System.out.println("-->2. " + x + " - " + y + "\n");
		
		for (int i = 0; i < piecesMatrix.length; i++) {
			for (int j = 0; j < piecesMatrix.length; j++) {
				System.out.print(piecesMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.print("\n");	
	}
	
		
	public void SelectedSquareColor(Graphics2D g2d, Color color, int x, int y)
	{
		if(chessBoardSquare[x][y])
		{
			g2d.setColor(color);
			
			if(piecesMatrix[x][y] > 0)
			{
				if(!chessSideChanger) 
				{
					if(piecesMatrix[x][y] >= 7 && piecesMatrix[x][y] <= 12) g2d.setColor(new Color(0,200,0));
					else g2d.setColor(color);;
				}
				else 
				{
					{if(piecesMatrix[x][y] >= 1 && piecesMatrix[x][y] <= 6) g2d.setColor(new Color(0,200,0));}
				}
				
			}
		}		
	}
	
	
	private int preX = -1 , preY = -1;
	private boolean preSide = chessSideChanger;
	
	public void SelectedSquare(int x, int y)
	{
		if(preX != -1 && preY != -1)
		{
			chessBoardSquare[preX][preY] = false;
			if(preX != x || preY != y)
			{
				preX = x;
				preY = y;
				chessBoardSquare[x][y] = true;
				
			}
			else
			{
				chessBoardSquare[x][y] = false;
				preX = -1;
				preY = -1;
			}
		}
		else
		{
			preX = x;
			preY = y;
			chessBoardSquare[x][y] = true;
		}
		
		if(piecesMatrix[x][y] != 0 && !chessSideChanger)
		{
			
		}
		pieces.PathOfPieces(chessBoardSquare, x, y, piecesMatrix[x][y]);
		chessSideChanger = pieces.isChessSideChanger();
		
		//---
		if(chessSideChanger != preSide)
		{
			game.setSideChanged(pieces.isChessSideChanger());
			System.out.println("\n\n" + pieces.getWhitePieces() + " - " + pieces.getBlackPieces());
			game.WhiteCheckPieces();
			game.CheckPieces(pieces.getWhiteChecker());
			game.BlackCheckPieces();
			game.CheckPieces(pieces.getBlackChecker());
			
			preSide = chessSideChanger;
		}
		//---
		/*
		System.out.println(chessSideChanger ? "Black" : "White");
		
		for (int i = 0; i < chessBoardCount; i++) {
			for (int j = 0; j < chessBoardCount; j++) {
				System.out.print(chessBoardSquare[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
		*/
	}
	
	

	public void ChessPieces(Graphics2D g2d)
	{
		for (int i = 0; i < piecesMatrix.length; i++) {
			for (int j = 0; j < piecesMatrix[i].length; j++) 
			{
				pieces.drawPieces(g2d, piecesMatrix[i][j] ,j * chessBoardSize,i * chessBoardSize);
			}
		}		
	}

	
	//------------------------------------- getter && setter
	
	public int getPreX() {
		return preX;
	}
	
	public void setPreX(int preX) {
		this.preX = preX;
	}
	
	public int getPreY() {
		return preY;
	}
	
	public void setPreY(int preY) {
		this.preY = preY;
	}
	
	public int getChessBoardCount() {
		return chessBoardCount;
	}

	public boolean[][] getChessBoardSquare() {
		return chessBoardSquare;
	}

	public void setChessBoardSquare(boolean[][] chessBoardSquare) {
		this.chessBoardSquare = chessBoardSquare;
	}

	public boolean isChessSideChanger() {
		return chessSideChanger;
	}

	public void setChessSideChanger(boolean chessSideChanger) {
		this.chessSideChanger = chessSideChanger;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
}
