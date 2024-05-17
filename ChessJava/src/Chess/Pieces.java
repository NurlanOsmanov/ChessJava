package Chess;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pieces extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Image whiteCastle, whiteQueen, whiteBishop, whitePawn, whiteKing, whiteKnight;
	private Image blackCastle, blackQueen, blackBishop, blackPawn, blackKing, blackKnight;
	
	private int piecesMatrix[][];
	
	private boolean chessSideChanger = false;
	
	private boolean WhiteKingMovement = false;
	private boolean BlackKingMovement = false;
	private boolean[] WhiteCastleMovement = {false, false};
	private boolean[] BlackCastleMovement = {false, false};
	
	private boolean[][] WhiteChecker; 
	private boolean[][] BlackChecker;
	
	private Point WhiteKingPosition;
	private Point BlackKingPosition;

	private byte whitePieces;
	private byte blackPieces;
	
	public Pieces() {
		
	}
	
	public Pieces(int chessBoardCount) 
	{	
		WhiteKingPosition = new Point();
		BlackKingPosition = new Point();
		piecesMatrix = new int[chessBoardCount][chessBoardCount];
		
		whitePieces = 0;
		blackPieces = 0;
		
		for (int i = 0; i < piecesMatrix.length; i++) 
			for (int j = 0; j < piecesMatrix[i].length; j++) 
				piecesMatrix[i][j] = 0;
		
		
		/*
		piecesMatrix[7][7] = 12;
		piecesMatrix[0][6] = 4;
		piecesMatrix[1][0] = 4;
		piecesMatrix[0][0] = 3;
		
		piecesMatrix[4][5] = 8;
		
		PiecesCount();
		*/
		
		for (int i = 0; i < piecesMatrix.length; i++) 
		{
			piecesMatrix[1][i] = 7;
			piecesMatrix[6][i] = 1;
		}
	
		piecesMatrix[0][0] = 10;
		piecesMatrix[0][7] = 10;
		piecesMatrix[7][0] = 4;
		piecesMatrix[7][7] = 4;
		
		piecesMatrix[0][1] = 8;
		piecesMatrix[0][6] = 8;
		piecesMatrix[7][1] = 2;
		piecesMatrix[7][6] = 2;
		
		piecesMatrix[0][2] = 9;
		piecesMatrix[0][5] = 9;
		piecesMatrix[7][2] = 3;
		piecesMatrix[7][5] = 3;
		
		piecesMatrix[0][3] = 11;
		piecesMatrix[0][4] = 12;
		piecesMatrix[7][3] = 5;
		piecesMatrix[7][4] = 6;
		
		PiecesCount();
		//image loading
		try {
			whiteCastle = new ImageIcon(getClass().getResource("WhiteCastle.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("WhiteCastle.png not found");
		}
		
		try {
			whiteBishop = new ImageIcon(getClass().getResource("WhiteBishop.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("WhiteBishop.png not found");
		}
		
		try {
			whiteKnight = new ImageIcon(getClass().getResource("WhiteKnight.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("WhiteKnight.png not found");
		}
		
		try {
			whiteKing = new ImageIcon(getClass().getResource("WhiteKing.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("WhiteKing.png not found");
		}
		
		try {
			whiteQueen = new ImageIcon(getClass().getResource("WhiteQueen.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("WhiteQueen.png not found");
		}
		
		try {
			whitePawn = new ImageIcon(getClass().getResource("WhitePawn.png")).getImage();
			
		} catch (Exception e) {
			System.out.print("WhiteQueen.png not found");
		}


		try {
			blackCastle = new ImageIcon(getClass().getResource("BlackCastle.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("BlackCastle.png not found");
		}
		
		try {
			blackBishop = new ImageIcon(getClass().getResource("BlackBishop.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("BlackBishop.png not found");
		}
		
		try {
			blackKnight = new ImageIcon(getClass().getResource("BlackKnight.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("BlackKnight.png not found");
		}
		
		try {
			blackKing = new ImageIcon(getClass().getResource("BlackKing.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("BlackKing.png not found");
		}
		
		try {
			blackQueen = new ImageIcon(getClass().getResource("BlackQueen.png")).getImage();
			
		} catch (Exception e) {
			System.out.println("BlackQueen.png not found");
		}
		
		try {
			blackPawn = new ImageIcon(getClass().getResource("BlackPawn.png")).getImage();
			
		} catch (Exception e) {
			System.out.print("BlackQueen.png not found");
		}
	}
	
	
	public void drawPieces(Graphics2D g2d, int i,int x,int y)
	{
		switch(i)
		{
		case 1 : drawWhitePawn(g2d ,x ,y); break;
		case 2 : drawWhiteKnight(g2d, x, y); break;
		case 3 : drawWhiteBishop(g2d ,x ,y); break;
		case 4 : drawWhiteCastle(g2d ,x ,y); break;
		case 5 : drawWhiteQueen(g2d ,x ,y); break;
		case 6 : drawWhiteKing(g2d ,x ,y); break;
		case 7 : drawBlackPawn(g2d ,x ,y); break;
		case 8 : drawBlackKnight(g2d, x, y); break;
		case 9 : drawBlackBishop(g2d ,x ,y); break;
		case 10 : drawBlackCastle(g2d ,x ,y); break;
		case 11 : drawBlackQueen(g2d ,x ,y); break;
		case 12 : drawBlackKing(g2d ,x ,y); break;
		default: break;
		}
		
	}
	
	public void PiecesCount()
	{
		for (int i = 0; i < piecesMatrix.length; i++) {
			for (int j = 0; j < piecesMatrix.length; j++) {
				if(piecesMatrix[i][j] > 0 && piecesMatrix[i][j] <= 6) 
				{
					if(piecesMatrix[i][j] == 6)
					{
						System.out.println("i - " + i + " j - " + j);
						WhiteKingPosition.setLocation(i,j);
					}
					whitePieces++;
				}
				if(piecesMatrix[i][j] > 6 && piecesMatrix[i][j] <= 12) 
				{
					if(piecesMatrix[i][j] == 12) BlackKingPosition.setLocation(i,j);
					blackPieces++;
				}
			}
		}
		
		System.out.println(WhiteKingPosition + " <-> " + BlackKingPosition);
	}
	
	public void drawWhiteCastle(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whiteCastle, x, y, null);
	}
	
	public void drawWhitePawn(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whitePawn, x, y, null);
	}
	
	public void drawWhiteBishop(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whiteBishop, x, y, null);
	}
	
	public void drawWhiteQueen(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whiteQueen, x, y, null);
	}
	
	public void drawWhiteKing(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whiteKing, x, y, null);
	}
	
	public void drawWhiteKnight(Graphics2D g2d, int x, int y){	
		g2d.drawImage(whiteKnight, x, y, null);
	}
	
	
	public void drawBlackCastle(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackCastle, x, y, null);
	}
	
	public void drawBlackPawn(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackPawn, x, y, null);
	}
	
	public void drawBlackBishop(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackBishop, x, y, null);
	}
	
	public void drawBlackQueen(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackQueen, x, y, null);
	}
	
	public void drawBlackKing(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackKing, x, y, null);
	}
	
	public void drawBlackKnight(Graphics2D g2d, int x, int y){	
		g2d.drawImage(blackKnight, x, y, null);
	}

	
	int preX = -1, preY = -1;
	public void PathOfPieces(boolean[][] movement,int x, int y, int i)
	{
		
		if(preX != -1 && preY != -1)
		{
			if(!chessSideChanger)
			{
				switch(i)
				{
				case 1 :  
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhitePawn(x, y, movement); 
					break;
				case 2 : 
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhiteKnight(x, y, movement);	
					break;
				case 3 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhiteBishop(x, y, movement);	
					break;
				case 4 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhiteCastle(x, y, movement);	
					break;
				case 5 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhiteQueen(x, y, movement);	
					break;
				case 6 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					WhiteKing(x, y, movement);	
					break;
				default:
					if(piecesMatrix[preX][preY] != 0) ClearMovement(preX, preY, movement);
					break;
				}
			}
			else
			{
				switch(i) {
				case 7:
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackPawn(x, y, movement); 
					break;
				case 8 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackKnight(x, y, movement);
					break;
				case 9 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackBishop(x, y, movement); 
					break;
				case 10 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackCastle(x, y, movement);
					break;
				case 11 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackQueen(x, y, movement);
					break;
				case 12 :
					ClearMovement(preX, preY, movement);
					if(!movement[x][y] && (preX != x || preY != y)) movement[x][y] = true;
					BlackKing(x, y, movement);
					break;
				default:
					if(piecesMatrix[preX][preY] != 0) ClearMovement(preX, preY, movement);
					break;
				}
			}
			
			MovementOfPieces(x, y, movement);
			
			preX = x;
			preY = y;
		}
		else
		{
			if(!chessSideChanger)
			{
				switch(piecesMatrix[x][y])
				{
				case 1 : 
					WhitePawn(x, y, movement); 
					break;
				case 2 :
					WhiteKnight(x, y, movement);
					break;
				case 3 :
					WhiteBishop(x, y, movement); 
					break;
				case 4 :
					WhiteCastle(x, y, movement);
					break;
				case 5 :
					WhiteQueen(x, y, movement);
					break;
				case 6 :
					WhiteKing(x, y, movement);
					break;
				default :
					break;
				}
			}
			else
			{
				switch(piecesMatrix[x][y])
				{
				case 7:
					BlackPawn(x, y, movement); 
					break;
				case 8 :
					BlackKnight(x, y, movement);
					break;
				case 9 :
					BlackBishop(x, y, movement); 
					break;
				case 10 :
					BlackCastle(x, y, movement);
					break;
				case 11 :
					BlackQueen(x, y, movement);
					break;
				case 12 :
					BlackKing(x, y, movement);
					break;
				default: break;
				}
			
			}		
			
			preX = x;
			preY = y;
		}
	}
	
	public void CheckingCheck(boolean[][] movement,int x, int y, int i)
	{
		switch(i)
		{
		case 1 : 
			WhitePawn(x, y, movement); 
			break;
		case 2 :
			WhiteKnight(x, y, movement);
			break;
		case 3 :
			WhiteBishop(x, y, movement); 
			break;
		case 4 :
			WhiteCastle(x, y, movement);
			break;
		case 5 :
			WhiteQueen(x, y, movement);
			break;
		case 6 :
			WhiteKing(x, y, movement);
			break;
		case 7:
			BlackPawn(x, y, movement); 
			break;
		case 8 :
			BlackKnight(x, y, movement);
			break;
		case 9 :
			BlackBishop(x, y, movement); 
			break;
		case 10 :
			BlackCastle(x, y, movement);
			break;
		case 11 :
			BlackQueen(x, y, movement);
			break;
		case 12 :
			BlackKing(x, y, movement);
			break;
		default: break;
		}
	}
	
	public void MovementOfPieces(int x, int y, boolean[][] movement)
	{
		if(!movement[x][y] && (preX != x || preY != y))
		{ 
			
			if(chessSideChanger && (piecesMatrix[x][y] > 0 && piecesMatrix[x][y] <= 6)) whitePieces--;
			if(!chessSideChanger && (piecesMatrix[x][y] > 6 && piecesMatrix[x][y] <= 12)) blackPieces--;
			
			piecesMatrix[x][y] = piecesMatrix[preX][preY];
			piecesMatrix[preX][preY] = 0;
			
			 
			if(chessSideChanger) chessSideChanger = false;
			else chessSideChanger = true;
			
			if(piecesMatrix[x][y] == 6 && ((x == 7 && y == 2) || (x == 7 && y == 6)) && preX == 7 && preY == 4)
			{
				if(x == 7 && y == 2) 
				{
					piecesMatrix[x][3] = piecesMatrix[x][0];
					piecesMatrix[x][0] = 0;
					WhiteCastleMovement[0] = true;
				}
				if(x == 7 && y == 6) 
				{
					piecesMatrix[x][5] = piecesMatrix[x][7];
					piecesMatrix[x][7] = 0;
					WhiteCastleMovement[1] = true;
				}
			}
			
			if(piecesMatrix[x][y] == 12 && ((x == 0 && y == 2) || (x == 0 && y == 6)) && preX == 0 && preY == 4)
			{
				if(x == 0 && y == 2) 
				{
					piecesMatrix[x][3] = piecesMatrix[x][0];
					piecesMatrix[x][0] = 0;
					BlackCastleMovement[0] = true;
				}
				if(x == 0 && y == 6) 
				{
					piecesMatrix[x][5] = piecesMatrix[x][7];
					piecesMatrix[x][7] = 0;
					BlackCastleMovement[1] = true;
				}
			}
			
			if(piecesMatrix[x][y] == 6) WhiteKingPosition.move(x, y);
			if(piecesMatrix[x][y] == 12) BlackKingPosition.move(x, y);
			
			if(!WhiteKingMovement && piecesMatrix[x][y] == 6) WhiteKingMovement = true;
			if(!BlackKingMovement && piecesMatrix[x][y] == 12) BlackKingMovement = true;
			
			if(!WhiteCastleMovement[0] && piecesMatrix[x][y] == 4) WhiteCastleMovement[0] = true;
			if(!WhiteCastleMovement[1] && piecesMatrix[x][y] == 4) WhiteCastleMovement[1] = true;
			if(!BlackCastleMovement[0] && piecesMatrix[x][y] == 10) BlackCastleMovement[0] = true;
			if(!BlackCastleMovement[1] && piecesMatrix[x][y] == 10) BlackCastleMovement[1] = true;
		}
	}
	


	public void ClearMovement(int x,int y, boolean[][] movement)
	{
		if(!chessSideChanger)
			switch(piecesMatrix[x][y])
			{
			case 1 : 
				WhitePawn(x, y, movement); 
				break;
			case 2 :
				WhiteKnight(x, y, movement);
				break;
			case 3 :
				WhiteBishop(x, y, movement); 
				break;
			case 4 :
				WhiteCastle(x, y, movement);
				break;
			case 5 :
				WhiteQueen(x, y, movement);
				break;
			case 6 :
				WhiteKing(x, y, movement);
				break;
			default :
				break;
			}
		else
			switch(piecesMatrix[x][y])
			{
			case 7:
				BlackPawn(x, y, movement); 
				break;
			case 8 :
				BlackKnight(x, y, movement);
				break;
			case 9 :
				BlackBishop(x, y, movement); 
				break;
			case 10 :
				BlackCastle(x, y, movement);
				break;
			case 11 :
				BlackQueen(x, y, movement);
				break;
			case 12 :
				BlackKing(x, y, movement);
				break;
			default: break;
			}
		
	}
	
	
	private boolean WhiteCastlingPosibility = false;
	private boolean BlackCastlingPosibility = false;
	public void WhiteCastling(boolean[][] movement)
	{
		System.out.println("-->>>" + movement[piecesMatrix.length - 1][4]);

		if(movement[piecesMatrix.length - 1][4])
		{
			if(!WhiteKingMovement && !WhiteCastleMovement[0])
			{
				for (int i = 1; i < 4; i++) {
					if(piecesMatrix[piecesMatrix.length - 1][4 - i] == 0) 
					{
						movement[piecesMatrix.length - 1][4 - i] = true;
						WhiteCastlingPosibility = true;
					}
					else
					{
						WhiteCastlingPosibility = false;
						break;	
					}
				}
				
				if(WhiteCastlingPosibility)
				{
					movement[piecesMatrix.length - 1][1] = false;
				}
				else
				{
					movement[piecesMatrix.length - 1][1] = false;
					movement[piecesMatrix.length - 1][2] = false;
				}
			}
			
			if(!WhiteKingMovement && !WhiteCastleMovement[1])
			{
				for (int i = 1; i <= 3; i++) {
					if(piecesMatrix[piecesMatrix.length - 1][4 + i] == 0) 
					{
						movement[piecesMatrix.length - 1][4 + i] = true;
						WhiteCastlingPosibility = true;
					}
					else 
					{
						WhiteCastlingPosibility = false;
						break;
					}
					
				}
				
				
			}
		}
		else
		{
			if(!WhiteKingMovement && !WhiteCastleMovement[0])
			{
				for (int i = 1; i < 4; i++) {
					if(piecesMatrix[piecesMatrix.length - 1][4 - i] == 0) 
					{
						movement[piecesMatrix.length - 1][4 - i] = false;
						WhiteCastlingPosibility = false;
					}
					else 
					{
						WhiteCastlingPosibility = false;
						break;
					}
				}
			}
			
			if(!WhiteKingMovement && !WhiteCastleMovement[1])
			{
				for (int i = 1; i <= 3; i++) {
					if(piecesMatrix[piecesMatrix.length - 1][4 + i] == 0) 
					{
						movement[piecesMatrix.length - 1][4 + i] = false;
						WhiteCastlingPosibility = false;
					}
				}
				
			}
		}
		
	}
	
	public void BlackCastling(boolean[][] movement)
	{
		if(movement[0][4])
		{
			if(!BlackKingMovement && !BlackCastleMovement[0])
			{
				for (int i = 1; i < 4; i++) {
					if(piecesMatrix[0][4 - i] == 0) 
					{
						movement[0][4 - i] = true;
						BlackCastlingPosibility = true;
					}
					else
					{
						BlackCastlingPosibility = false;
						break;	
					}
				}
				
				if(BlackCastlingPosibility)
				{
					movement[0][1] = false;
				}
				else
				{
					movement[0][1] = false;
					movement[0][2] = false;
				}
			}
			
			if(!BlackKingMovement && !BlackCastleMovement[1])
			{
				for (int i = 1; i <= 3; i++) {
					if(piecesMatrix[0][4 + i] == 0) 
					{
						movement[0][4 + i] = true;
						BlackCastlingPosibility = true;
					}
					else 
					{
						BlackCastlingPosibility = false;
						break;
					}
					
				}	
			}
		}
		else
		{
			if(!BlackKingMovement && !BlackCastleMovement[0])
			{
				for (int i = 1; i < 4; i++) {
					if(piecesMatrix[0][4 - i] == 0) 
					{
						movement[0][4 - i] = false;
						BlackCastlingPosibility = false;
					}
					else 
					{
						break;
					}
				}
			}
			
			if(!BlackKingMovement && !BlackCastleMovement[1])
			{
				for (int i = 1; i <= 3; i++) {
					if(piecesMatrix[0][4 + i] == 0) 
					{
						movement[0][4 + i] = false;
					}
				}
				
			}
		}
		
	}
	
	
	//------------------------------- pieces movement
	
	public void WhitePawn(int x, int y, boolean[][] movement)
	{
		if(x - 1 >= 0)
			if(piecesMatrix[x - 1][y] == 0) 
			{
				movement[x - 1][y] = true;
				if(x == movement.length - 2 && x - 2 >= 0) if(piecesMatrix[x - 2][y] == 0) movement[x - 2][y] = true;
			}
			
		if(x - 1 >=0 && y - 1 >= 0)
			if(piecesMatrix[x - 1][y - 1] >= 7 && piecesMatrix[x - 1][y - 1] <= 12) movement[x - 1][y - 1] = true;
			
		if(x - 1 >=0 && y + 1 < movement.length)
			if(piecesMatrix[x - 1][y + 1] >= 7 && piecesMatrix[x - 1][y + 1] <= 12) movement[x - 1][y + 1] = true;
	
		if(!movement[x][y])
		{
			if(x - 1 >= 0)
				if(piecesMatrix[x - 1][y] == 0) 
				{
					movement[x - 1][y] = false;
					if(x == movement.length - 2 && x - 2 >= 0) if(piecesMatrix[x - 2][y] == 0) movement[x - 2][y] = false;
				}
				
			if(x - 1 >=0 && y - 1 >= 0)
				if(piecesMatrix[x - 1][y - 1] >= 7 && piecesMatrix[x - 1][y - 1] <= 12) movement[x - 1][y - 1] = false;
				
			if(x - 1 >=0 && y + 1 < movement.length)
				if(piecesMatrix[x - 1][y + 1] >= 7 && piecesMatrix[x - 1][y + 1] <= 12) movement[x - 1][y + 1] = false;
		}		
		
	}
	
	public void BlackPawn(int x, int y, boolean[][] movement)
	{
		if(x + 1 < movement.length)
			if(piecesMatrix[x + 1][y] == 0) 
			{
				movement[x + 1][y] = true;
				if(x == 1 && x + 2 < movement.length) if(piecesMatrix[x + 2][y] == 0) movement[x + 2][y] = true;
			}
			
		if(x + 1 < movement.length && y - 1 >= 0)
			if(piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12) movement[x + 1][y - 1] = true;
			
		if(x + 1 < movement.length && y + 1 < movement.length)
			if(piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12) movement[x + 1][y + 1] = true;
	
		if(!movement[x][y])
		{
			if(x + 1 < movement.length)
				if(piecesMatrix[x + 1][y] == 0) 
				{
					movement[x + 1][y] = false;
					if(x == 1 && x + 2 < movement.length) if(piecesMatrix[x + 2][y] == 0) movement[x + 2][y] = false;
				}				
			if(x + 1 < movement.length && y - 1 >= 0)
				if(piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12) movement[x + 1][y - 1] = false;
				
			if(x + 1 < movement.length && y + 1 < movement.length)
				if(piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12) movement[x + 1][y + 1] = false;
		}
		
	}
	
	public void WhiteKnight(int x, int y, boolean[][] movement)
	{
			if(x - 1 >=0 && y - 2 >= 0) if(piecesMatrix[x - 1][y - 2] == 0 || (piecesMatrix[x - 1][y - 2] >= 1 && piecesMatrix[x - 1][y - 2] <= 12)) movement[x - 1][y - 2] = true;
			if(x - 2 >=0 && y - 1 >= 0) if(piecesMatrix[x - 2][y - 1] == 0 || (piecesMatrix[x - 2][y - 1] >= 1 && piecesMatrix[x - 2][y - 1] <= 12)) movement[x - 2][y - 1] = true;
			if(x - 2 >=0 && y + 1 < movement.length) if(piecesMatrix[x - 2][y + 1] == 0 || (piecesMatrix[x - 2][y + 1] >= 1 && piecesMatrix[x - 2][y + 1] <= 12))  movement[x - 2][y + 1] = true;
			if(x - 1 >=0 && y + 2 < movement.length) if(piecesMatrix[x - 1][y + 2] == 0 || (piecesMatrix[x - 1][y + 2] >= 1 && piecesMatrix[x - 1][y + 2] <= 12))  movement[x - 1][y + 2] = true;
			if(x + 1 < movement.length && y + 2 < movement.length) if(piecesMatrix[x + 1][y + 2] == 0 || (piecesMatrix[x + 1][y + 2] >= 1 && piecesMatrix[x + 1][y + 2] <= 12)) movement[x + 1][y + 2] = true;
			if(x + 2 < movement.length && y + 1 < movement.length) if(piecesMatrix[x + 2][y + 1] == 0 || (piecesMatrix[x + 2][y + 1] >= 1 && piecesMatrix[x + 2][y + 1] <= 12)) movement[x + 2][y + 1] = true;
			if(x + 2 < movement.length && y - 1 >= 0) if(piecesMatrix[x + 2][y - 1] == 0 || (piecesMatrix[x + 2][y - 1] >= 1 && piecesMatrix[x + 2][y - 1] <= 12))  movement[x + 2][y - 1] = true;
			if(x + 1 < movement.length && y - 2 >= 0) if(piecesMatrix[x + 1][y - 2] == 0 || (piecesMatrix[x + 1][y - 2] >= 1 && piecesMatrix[x + 1][y - 2] <= 12)) movement[x + 1][y - 2] = true;
		
		if(!movement[x][y])
		{
			if(x - 1 >=0 && y - 2 >= 0) if(piecesMatrix[x - 1][y - 2] == 0 || (piecesMatrix[x - 1][y - 2] >= 1 && piecesMatrix[x - 1][y - 2] <= 12)) movement[x - 1][y - 2] = false;
			if(x - 2 >=0 && y - 1 >= 0) if(piecesMatrix[x - 2][y - 1] == 0 || (piecesMatrix[x - 2][y - 1] >= 1 && piecesMatrix[x - 2][y - 1] <= 12)) movement[x - 2][y - 1] = false;
			if(x - 2 >=0 && y + 1 < movement.length) if(piecesMatrix[x - 2][y + 1] == 0 || (piecesMatrix[x - 2][y + 1] >= 1 && piecesMatrix[x - 2][y + 1] <= 12))  movement[x - 2][y + 1] = false;
			if(x - 1 >=0 && y + 2 < movement.length) if(piecesMatrix[x - 1][y + 2] == 0 || (piecesMatrix[x - 1][y + 2] >= 1 && piecesMatrix[x - 1][y + 2] <= 12))  movement[x - 1][y + 2] = false;
			if(x + 1 < movement.length && y + 2 < movement.length) if(piecesMatrix[x + 1][y + 2] == 0 || (piecesMatrix[x + 1][y + 2] >= 1 && piecesMatrix[x + 1][y + 2] <= 12)) movement[x + 1][y + 2] = false;
			if(x + 2 < movement.length && y + 1 < movement.length) if(piecesMatrix[x + 2][y + 1] == 0 || (piecesMatrix[x + 2][y + 1] >= 1 && piecesMatrix[x + 2][y + 1] <= 12)) movement[x + 2][y + 1] = false;
			if(x + 2 < movement.length && y - 1 >= 0) if(piecesMatrix[x + 2][y - 1] == 0 || (piecesMatrix[x + 2][y - 1] >= 1 && piecesMatrix[x + 2][y - 1] <= 12))  movement[x + 2][y - 1] = false;
			if(x + 1 < movement.length && y - 2 >= 0) if(piecesMatrix[x + 1][y - 2] == 0 || (piecesMatrix[x + 1][y - 2] >= 1 && piecesMatrix[x + 1][y - 2] <= 12)) movement[x + 1][y - 2] = false;
		}
	}
	
	public void BlackKnight(int x, int y, boolean[][] movement)
	{
			if(x - 1 >=0 && y - 2 >= 0) if(piecesMatrix[x - 1][y - 2] == 0 || (piecesMatrix[x - 1][y - 2] >= 1 && piecesMatrix[x - 1][y - 2] <= 12)) movement[x - 1][y - 2] = true;
			if(x - 2 >=0 && y - 1 >= 0) if(piecesMatrix[x - 2][y - 1] == 0 || (piecesMatrix[x - 2][y - 1] >= 1 && piecesMatrix[x - 2][y - 1] <= 12)) movement[x - 2][y - 1] = true;
			if(x - 2 >=0 && y + 1 < movement.length) if(piecesMatrix[x - 2][y + 1] == 0 || (piecesMatrix[x - 2][y + 1] >= 1 && piecesMatrix[x - 2][y + 1] <= 12))  movement[x - 2][y + 1] = true;
			if(x - 1 >=0 && y + 2 < movement.length) if(piecesMatrix[x - 1][y + 2] == 0 || (piecesMatrix[x - 1][y + 2] >= 1 && piecesMatrix[x - 1][y + 2] <= 12))  movement[x - 1][y + 2] = true;
			if(x + 1 < movement.length && y + 2 < movement.length) if(piecesMatrix[x + 1][y + 2] == 0 || (piecesMatrix[x + 1][y + 2] >= 1 && piecesMatrix[x + 1][y + 2] <= 12)) movement[x + 1][y + 2] = true;
			if(x + 2 < movement.length && y + 1 < movement.length) if(piecesMatrix[x + 2][y + 1] == 0 || (piecesMatrix[x + 2][y + 1] >= 1 && piecesMatrix[x + 2][y + 1] <= 12)) movement[x + 2][y + 1] = true;
			if(x + 2 < movement.length && y - 1 >= 0) if(piecesMatrix[x + 2][y - 1] == 0 || (piecesMatrix[x + 2][y - 1] >= 1 && piecesMatrix[x + 2][y - 1] <= 12))  movement[x + 2][y - 1] = true;
			if(x + 1 < movement.length && y - 2 >= 0) if(piecesMatrix[x + 1][y - 2] == 0 || (piecesMatrix[x + 1][y - 2] >= 1 && piecesMatrix[x + 1][y - 2] <= 12)) movement[x + 1][y - 2] = true;
		if(!movement[x][y])
		{
			if(x - 1 >=0 && y - 2 >= 0) if(piecesMatrix[x - 1][y - 2] == 0 || (piecesMatrix[x - 1][y - 2] >= 1 && piecesMatrix[x - 1][y - 2] <= 12)) movement[x - 1][y - 2] = false;
			if(x - 2 >=0 && y - 1 >= 0) if(piecesMatrix[x - 2][y - 1] == 0 || (piecesMatrix[x - 2][y - 1] >= 1 && piecesMatrix[x - 2][y - 1] <= 12)) movement[x - 2][y - 1] = false;
			if(x - 2 >=0 && y + 1 < movement.length) if(piecesMatrix[x - 2][y + 1] == 0 || (piecesMatrix[x - 2][y + 1] >= 1 && piecesMatrix[x - 2][y + 1] <= 12))  movement[x - 2][y + 1] = false;
			if(x - 1 >=0 && y + 2 < movement.length) if(piecesMatrix[x - 1][y + 2] == 0 || (piecesMatrix[x - 1][y + 2] >= 1 && piecesMatrix[x - 1][y + 2] <= 12))  movement[x - 1][y + 2] = false;
			if(x + 1 < movement.length && y + 2 < movement.length) if(piecesMatrix[x + 1][y + 2] == 0 || (piecesMatrix[x + 1][y + 2] >= 1 && piecesMatrix[x + 1][y + 2] <= 12)) movement[x + 1][y + 2] = false;
			if(x + 2 < movement.length && y + 1 < movement.length) if(piecesMatrix[x + 2][y + 1] == 0 || (piecesMatrix[x + 2][y + 1] >= 1 && piecesMatrix[x + 2][y + 1] <= 12)) movement[x + 2][y + 1] = false;
			if(x + 2 < movement.length && y - 1 >= 0) if(piecesMatrix[x + 2][y - 1] == 0 || (piecesMatrix[x + 2][y - 1] >= 1 && piecesMatrix[x + 2][y - 1] <= 12))  movement[x + 2][y - 1] = false;
			if(x + 1 < movement.length && y - 2 >= 0) if(piecesMatrix[x + 1][y - 2] == 0 || (piecesMatrix[x + 1][y - 2] >= 1 && piecesMatrix[x + 1][y - 2] <= 12)) movement[x + 1][y - 2] = false;
		}
	}
	
	public void WhiteCastle(int x, int y, boolean[][] movement)
	{
		
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = true;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = true;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = true;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = true;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = true;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = true;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = true;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = true;
						break;
					}
				}
			}
			
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = false;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = false;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = false;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = false;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = false;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = false;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = false;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = false;
						break;
					}
				}
			}
		}
	}
	
	public void BlackCastle(int x, int y, boolean[][] movement)
	{
		
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = true;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = true;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = true;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = true;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = true;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = true;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = true;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = true;
						break;
					}
				}
			}
			
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = false;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = false;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = false;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = false;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = false;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = false;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = false;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = false;
						break;
					}
				}
			}
		}
	}
	
	private void WhiteBishop(int x, int y, boolean[][] movement) 
	{
		
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = true;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = true;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = true;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = true;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = true;
						break;
					}
			}
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = false;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = false;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = false;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = false;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = false;
						break;
					}
			}
		}

	}
	
	private void BlackBishop(int x, int y, boolean[][] movement) 
	{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = true;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = true;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = true;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = true;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = true;
						break;
					}
			}
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = false;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = false;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = false;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = false;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = false;
						break;
					}
			}
		}

	}
	
	public void WhiteQueen(int x, int y, boolean[][] movement)
	{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0 || piecesMatrix[x + i][y - i] == 12) movement[x + i][y - i] = true;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] < 12) movement[x + i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0 || piecesMatrix[x + i][y + i] == 12) movement[x + i][y + i] = true;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0 || piecesMatrix[x - i][y - i] == 12) movement[x - i][y - i] = true;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0 || piecesMatrix[x - i][y + i] == 12) movement[x - i][y + i] = true;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
					if(piecesMatrix[x][y - i] == 0 || piecesMatrix[x][y - i] == 12) movement[x][y - i] = true;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = true;
						break;
					}				
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 || piecesMatrix[x][y + i] == 12) movement[x][y + i] = true;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = true;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0 || piecesMatrix[x - i][y] == 12) movement[x - i][y] = true;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = true;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 || piecesMatrix[x + i][y] == 12) movement[x + i][y] = true;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = true;
						break;
					}
				}
			}
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0 || piecesMatrix[x + i][y - i] == 12) movement[x + i][y - i] = false;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0 || piecesMatrix[x + i][y + i] == 12) movement[x + i][y + i] = false;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0 || piecesMatrix[x - i][y - i] == 12) movement[x - i][y - i] = false;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0 || piecesMatrix[x - i][y + i] == 12) movement[x - i][y + i] = false;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0 || piecesMatrix[x][y - i] == 12) movement[x][y - i] = false;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = false;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 || piecesMatrix[x][y + i] == 12) movement[x][y + i] = false;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = false;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0 || piecesMatrix[x - i][y] == 12) movement[x - i][y] = false;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = false;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 || piecesMatrix[x + i][y] == 12) movement[x + i][y] = false;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = false;
						break;
					}
				}
			}
		}
	}
	
	public void BlackQueen(int x, int y, boolean[][] movement)
	{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = true;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = true;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = true;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = true;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = true;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = true;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = true;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = true;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = true;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = true;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = true;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = true;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = true;
						break;
					}
				}
			}
		if(!movement[x][y])
		{
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y - i >= 0)
					if(piecesMatrix[x + i][y - i] == 0) movement[x + i][y - i] = false;
					else 
					{
						if(piecesMatrix[x + i][y - i] >= 1 && piecesMatrix[x + i][y - i] <= 12) movement[x + i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length && y + i < movement.length)
					if(piecesMatrix[x + i][y + i] == 0) movement[x + i][y + i] = false;
					else 
					{
						if(piecesMatrix[x + i][y + i] >= 1 && piecesMatrix[x + i][y + i] <= 12) movement[x + i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y - i >= 0)
					if(piecesMatrix[x - i][y - i] == 0) movement[x - i][y - i] = false;
					else 
					{
						if(piecesMatrix[x - i][y - i] >= 1 && piecesMatrix[x - i][y - i] <= 12) movement[x - i][y - i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x - i >= 0 && y + i < movement.length)
					if(piecesMatrix[x - i][y + i] == 0) movement[x - i][y + i] = false;
					else 
					{
						if(piecesMatrix[x - i][y + i] >= 1 && piecesMatrix[x - i][y + i] <= 12) movement[x - i][y + i] = false;
						break;
					}
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(y - i >= 0)
				{
					if(piecesMatrix[x][y - i] == 0) movement[x][y - i] = false;
					else 
					{
						if(piecesMatrix[x][y - i] >= 1 && piecesMatrix[x][y - i] <= 12) movement[x][y - i] = false;
						break;
					}
				}				
			}
			
			
			for (int i = 1; i <= movement.length; i++) 
			{
				if(y + i < movement.length)
				{
					
					if(piecesMatrix[x][y + i] == 0 ) movement[x][y + i] = false;
					else 
					{
						if(piecesMatrix[x][y + i] >= 1 && piecesMatrix[x][y + i] <= 12) movement[x][y + i] = false;
						break;
					}
				}
			}
			
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x-i >= 0)
				{
					if(piecesMatrix[x - i][y] == 0) movement[x - i][y] = false;
					else 
					{
						if(piecesMatrix[x - i][y] >= 1 && piecesMatrix[x - i][y] <= 12) movement[x - i][y] = false;
						break;
					}
				}		
			}
			
			for (int i = 1; i < movement.length; i++) 
			{
				if(x + i < movement.length)
				{
					if(piecesMatrix[x + i][y] == 0 ) movement[x + i][y] = false;
					else 
					{
						if(piecesMatrix[x + i][y] >= 1 && piecesMatrix[x + i][y] <= 12) movement[x + i][y] = false;
						break;
					}
				}
			}
		}
	}
	
	public void WhiteKing(int x,int y, boolean[][] movement)
	{
		if(y - 1 >= 0) if(!BlackChecker[x][y - 1] && (piecesMatrix[x][y - 1] == 0 || (piecesMatrix[x][y - 1] >= 1 && piecesMatrix[x][y - 1] <= 12))) movement[x][y - 1] = true;
		if(x - 1 >=0 && y - 1 >= 0) if(!BlackChecker[x - 1][y - 1] && (piecesMatrix[x - 1][y - 1] == 0 || (piecesMatrix[x - 1][y - 1] >= 1 && piecesMatrix[x - 1][y - 1] <= 12))) movement[x - 1][y - 1] = true;
		if(x + 1 < movement.length && y - 1 >= 0) if(!BlackChecker[x + 1][y - 1] && (piecesMatrix[x + 1][y - 1] == 0 || (piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12))) movement[x + 1][y - 1] = true;
		if(x + 1 < movement.length) if(!BlackChecker[x + 1][y] && (piecesMatrix[x + 1][y] == 0 || (piecesMatrix[x + 1][y] >= 1 && piecesMatrix[x + 1][y] <= 12))) movement[x + 1][y] = true;
		if(x - 1 >= 0) if(!BlackChecker[x - 1][y] && (piecesMatrix[x - 1][y] == 0 || (piecesMatrix[x - 1][y] >= 1 && piecesMatrix[x - 1][y] <= 12))) movement[x - 1][y] = true;
		if(y + 1 < movement.length) if(!BlackChecker[x][y + 1] && (piecesMatrix[x][y + 1] == 0 || (piecesMatrix[x][y + 1] >= 1 && piecesMatrix[x][y + 1] <= 12))) movement[x][y + 1] = true;
		if(x - 1 >= 0 && y + 1 < movement.length) if(!BlackChecker[x - 1][y + 1] && (piecesMatrix[x - 1][y + 1] == 0 || (piecesMatrix[x - 1][y + 1] >= 1 && piecesMatrix[x - 1][y + 1] <= 12))) movement[x - 1][y + 1] = true;
		if(x + 1 < movement.length && y + 1 < movement.length) if(!BlackChecker[x + 1][y + 1] && (piecesMatrix[x + 1][y + 1] == 0 || (piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12))) movement[x + 1][y + 1] = true;
	if(!movement[x][y])
	{
		if(y - 1 >= 0) if(!BlackChecker[x][y - 1] && (piecesMatrix[x][y - 1] == 0 || (piecesMatrix[x][y - 1] >= 1 && piecesMatrix[x][y - 1] <= 12))) movement[x][y - 1] = false;
		if(x - 1 >=0 && y - 1 >= 0) if(!BlackChecker[x - 1][y - 1] && (piecesMatrix[x - 1][y - 1] == 0 || (piecesMatrix[x - 1][y - 1] >= 1 && piecesMatrix[x - 1][y - 1] <= 12))) movement[x - 1][y - 1] = false;
		if(x + 1 < movement.length && y - 1 >= 0) if(!BlackChecker[x + 1][y - 1] && (piecesMatrix[x + 1][y - 1] == 0 || (piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12))) movement[x + 1][y - 1] = false;
		if(x + 1 < movement.length) if(!BlackChecker[x + 1][y] && (piecesMatrix[x + 1][y] == 0 || (piecesMatrix[x + 1][y] >= 1 && piecesMatrix[x + 1][y] <= 12))) movement[x + 1][y] = false;
		if(x - 1 >= 0) if(!BlackChecker[x - 1][y] && (piecesMatrix[x - 1][y] == 0 || (piecesMatrix[x - 1][y] >= 1 && piecesMatrix[x - 1][y] <= 12))) movement[x - 1][y] = false;
		if(y + 1 < movement.length) if(!BlackChecker[x][y + 1] && (piecesMatrix[x][y + 1] == 0 || (piecesMatrix[x][y + 1] >= 1 && piecesMatrix[x][y + 1] <= 12))) movement[x][y + 1] = false;
		if(x - 1 >= 0 && y + 1 < movement.length) if(!BlackChecker[x - 1][y + 1] && (piecesMatrix[x - 1][y + 1] == 0 || (piecesMatrix[x - 1][y + 1] >= 1 && piecesMatrix[x - 1][y + 1] <= 12))) movement[x - 1][y + 1] = false;
		if(x + 1 < movement.length && y + 1 < movement.length) if(!BlackChecker[x + 1][y + 1] && (piecesMatrix[x + 1][y + 1] == 0 || (piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12))) movement[x + 1][y + 1] = false;
		WhiteCastling(movement);
	}
	}
	
	private boolean blackKingLockBool = false;
	public void BlackKing(int x,int y, boolean[][] movement)
	{
		 int blackKingLock = 0;
			if(y - 1 >= 0) 
			{
				if(!WhiteChecker[x][y - 1] && (piecesMatrix[x][y - 1] == 0 || (piecesMatrix[x][y - 1] >= 1 && piecesMatrix[x][y - 1] <= 12)))
				{
					movement[x][y - 1] = true;
					blackKingLock++;
				}
			}
			if(x - 1 >=0 && y - 1 >= 0)
			{
				if(!WhiteChecker[x - 1][y - 1] && (piecesMatrix[x - 1][y - 1] == 0 || (piecesMatrix[x - 1][y - 1] >= 1 && piecesMatrix[x - 1][y - 1] <= 12))) 
				{
					movement[x - 1][y - 1] = true;
					blackKingLock++;
				}
				
			}
			if(x + 1 < movement.length && y - 1 >= 0)
			{
				if(!WhiteChecker[x + 1][y - 1] && (piecesMatrix[x + 1][y - 1] == 0 || (piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12)))
				{
					movement[x + 1][y - 1] = true;
					blackKingLock++;
				}
				
			}
			if(x + 1 < movement.length)
			{
				if(!WhiteChecker[x + 1][y] && (piecesMatrix[x + 1][y] == 0 || (piecesMatrix[x + 1][y] >= 1 && piecesMatrix[x + 1][y] <= 12)))
				{
					movement[x + 1][y] = true;
					blackKingLock++;
				}
				
			}
			if(x - 1 >= 0)
			{
				if(!WhiteChecker[x - 1][y] && (piecesMatrix[x - 1][y] == 0 || (piecesMatrix[x - 1][y] >= 1 && piecesMatrix[x - 1][y] <= 12))) 
				{
					movement[x - 1][y] = true;
					blackKingLock++;
				}
				
			}
			if(y + 1 < movement.length) 
			{
				if(!WhiteChecker[x][y + 1] && (piecesMatrix[x][y + 1] == 0 || (piecesMatrix[x][y + 1] >= 1 && piecesMatrix[x][y + 1] <= 12))) 
				{
					movement[x][y + 1] = true;
					blackKingLock++;
				}
				
			}
			if(x - 1 >= 0 && y + 1 < movement.length)
			{
				if(!WhiteChecker[x - 1][y + 1] && (piecesMatrix[x - 1][y + 1] == 0 || (piecesMatrix[x - 1][y + 1] >= 1 && piecesMatrix[x - 1][y + 1] <= 12))) 
				{
					movement[x - 1][y + 1] = true;
					blackKingLock++;
				}
				
			}
			if(x + 1 < movement.length && y + 1 < movement.length)
			{
				if(!WhiteChecker[x + 1][y + 1] && (piecesMatrix[x + 1][y + 1] == 0 || (piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12))) 
				{
					movement[x + 1][y + 1] = true;
					blackKingLock++;
				}
				
			}
			
			System.out.println (blackKingLock);
			if(blackKingLock == 0) blackKingLockBool = true;
			else blackKingLockBool = false;
			
		if(!movement[x][y])
		{
			if(y - 1 >= 0) if(!WhiteChecker[x][y - 1] && (piecesMatrix[x][y - 1] == 0 || (piecesMatrix[x][y - 1] >= 1 && piecesMatrix[x][y - 1] <= 12))) movement[x][y - 1] = false;
			if(x - 1 >=0 && y - 1 >= 0) if(!WhiteChecker[x - 1][y - 1] && (piecesMatrix[x - 1][y - 1] == 0 || (piecesMatrix[x - 1][y - 1] >= 1 && piecesMatrix[x - 1][y - 1] <= 12))) movement[x - 1][y - 1] = false;
			if(x + 1 < movement.length && y - 1 >= 0) if(!WhiteChecker[x + 1][y - 1] && (piecesMatrix[x + 1][y - 1] == 0 || (piecesMatrix[x + 1][y - 1] >= 1 && piecesMatrix[x + 1][y - 1] <= 12))) movement[x + 1][y - 1] = false;
			if(x + 1 < movement.length) if(!WhiteChecker[x + 1][y] && (piecesMatrix[x + 1][y] == 0 || (piecesMatrix[x + 1][y] >= 1 && piecesMatrix[x + 1][y] <= 12))) movement[x + 1][y] = false;
			if(x - 1 >= 0) if(!WhiteChecker[x - 1][y] && (piecesMatrix[x - 1][y] == 0 || (piecesMatrix[x - 1][y] >= 1 && piecesMatrix[x - 1][y] <= 12))) movement[x - 1][y] = false;
			if(y + 1 < movement.length) if(!WhiteChecker[x][y + 1] && (piecesMatrix[x][y + 1] == 0 || (piecesMatrix[x][y + 1] >= 1 && piecesMatrix[x][y + 1] <= 12))) movement[x][y + 1] = false;
			if(x - 1 >= 0 && y + 1 < movement.length) if(!WhiteChecker[x - 1][y + 1] && (piecesMatrix[x - 1][y + 1] == 0 || (piecesMatrix[x - 1][y + 1] >= 1 && piecesMatrix[x - 1][y + 1] <= 12))) movement[x - 1][y + 1] = false;
			if(x + 1 < movement.length && y + 1 < movement.length) if(!WhiteChecker[x + 1][y + 1] && (piecesMatrix[x + 1][y + 1] == 0 || (piecesMatrix[x + 1][y + 1] >= 1 && piecesMatrix[x + 1][y + 1] <= 12))) movement[x + 1][y + 1] = false;
		}
		
		BlackCastling(movement);
	}
	
	//--------------------------------------getter && setter
	
	public int[][] getPiecesMatrix() {
		return piecesMatrix;
	}
	
	public void setPiecesMatrix(int[][] piecesMatrix) {
		this.piecesMatrix = piecesMatrix;
	}
	
	public byte getWhitePieces() {
		return whitePieces;
	}

	public void setWhitePieces(byte whitePieces) {
		this.whitePieces = whitePieces;
	}

	public byte getBlackPieces() {
		return blackPieces;
	}

	public void setBlackPieces(byte blackPieces) {
		this.blackPieces = blackPieces;
	}
	
	public boolean isChessSideChanger() {
		return chessSideChanger;
	}


	public void setChessSideChanger(boolean chessSideChanger) {
		this.chessSideChanger = chessSideChanger;
	}

	public Point getWhiteKingPosition() {
		return WhiteKingPosition;
	}

	public void setWhiteKingPosition(Point whiteKingPosition) {
		WhiteKingPosition = whiteKingPosition;
	}

	public Point getBlackKingPosition() {
		return BlackKingPosition;
	}

	public void setBlackKingPosition(Point blackKingPosition) {
		BlackKingPosition = blackKingPosition;
	}

	public boolean[][] getWhiteChecker() {
		return WhiteChecker;
	}

	public void setWhiteChecker(boolean[][] whiteChecker) {
		WhiteChecker = whiteChecker;
	}

	public boolean[][] getBlackChecker() {
		return BlackChecker;
	}

	public void setBlackChecker(boolean[][] blackChecker) {
		BlackChecker = blackChecker;
	}

	public boolean isBlackKingLockBool() {
		return blackKingLockBool;
	}

	public void setBlackKingLockBool(boolean blackKingLockBool) {
		this.blackKingLockBool = blackKingLockBool;
	}
	
	
}
