package Chess;

import java.awt.Point;
import java.util.ArrayList;

public class Game
{
	private int chessBoardSize;
	private int PiecesPosition[][];
	
	private boolean isSideChanged = false;
	private boolean[][] Movement;
	
	private boolean[][] WhiteCheck;
	private boolean[][] BlackCheck;
	
	private byte whiteCount;
	private byte blackCount;
	
	private boolean CheckToBlack;
	private boolean CheckToWhite;
	
	private boolean[][] protectedPiecesBlack;
	private boolean[][] protectedPiecesWhite;
	
	private ArrayList<Point> CheckerPosition;
	
	Pieces pieces;
	
	public Game(int chessBoardSize, int[][] PiecesPosition, Pieces pieces)
	{
		CheckerPosition = new ArrayList<>();
		
		this.chessBoardSize = chessBoardSize;
		this.pieces = pieces;
		this.PiecesPosition = PiecesPosition;
		
		Movement = new boolean[chessBoardSize][chessBoardSize];
		
		whiteCount = pieces.getWhitePieces();
		blackCount = pieces.getBlackPieces();
		
		WhiteCheck = new boolean[chessBoardSize][chessBoardSize];
		BlackCheck = new boolean[chessBoardSize][chessBoardSize];
		
		protectedPiecesBlack = new boolean[chessBoardSize][chessBoardSize];
		protectedPiecesWhite = new boolean[chessBoardSize][chessBoardSize];
		
		pieces.setWhiteChecker(WhiteCheck);
		pieces.setBlackChecker(BlackCheck);
	}	
	
	public void CheckPieces(boolean[][] checkMatis)
	{
		System.out.println("Buradadir: ");
		for (int i = 0; i < checkMatis.length; i++) {
			for (int j = 0; j < checkMatis.length; j++) {
				System.out.print(checkMatis[i][j] ? "1 " : "0 ");
			}
			System.out.println("");
		}
		System.out.print("\n");	
		
	}
	
	public void WhiteCheckPieces()
	{
		ClearCheking(WhiteCheck);
		System.out.println("White Checker - " + pieces.getWhiteKingPosition());
		for (int i = 0; i < WhiteCheck.length; i++)
			for (int j = 0; j < WhiteCheck.length; j++)
				if(PiecesPosition[i][j] > 0 && PiecesPosition[i][j] <= 6)
				{
					if(WhiteCheck[i][j]) protectedPiecesWhite[i][j] = true; 
					else protectedPiecesWhite[i][j] = false; 
					WhiteCheck[i][j] = true;
					pieces.CheckingCheck(WhiteCheck, i, j, PiecesPosition[i][j]);
					if(!protectedPiecesWhite[i][j])
					{
						WhiteCheck[i][j] = false;
					}
				}
		for (int i = WhiteCheck.length - 1; i >= 0; i--)
			for (int j = WhiteCheck.length - 1; j >= 0; j--)
				if(PiecesPosition[i][j] > 0 && PiecesPosition[i][j] <= 6)
				{
					if(WhiteCheck[i][j]) protectedPiecesWhite[i][j] = true; 
					else protectedPiecesWhite[i][j] = false; 
					WhiteCheck[i][j] = true;
					pieces.CheckingCheck(WhiteCheck, i, j, PiecesPosition[i][j]);
					if(!protectedPiecesWhite[i][j]) WhiteCheck[i][j] = false;
					if(PiecesPosition[i][j] == 1 && i + 1 < PiecesPosition.length)
					{
						if(PiecesPosition[i - 1][j] == 0)
						WhiteCheck[i - 1][j] = false;
					}
				}
		//CheckPieces(WhiteCheck);
		BlackCheckCheck(WhiteCheck);
		//ClearCheking(BlackCheck);
	}
	
	public void BlackCheckPieces()
	{
		ClearCheking(BlackCheck);
		System.out.println("Black Checker - " + pieces.getBlackKingPosition());
		for (int i = 0; i < BlackCheck.length; i++) 
			for (int j = 0; j < BlackCheck.length; j++)
			{
				if(PiecesPosition[i][j] > 6 && PiecesPosition[i][j] <= 12)
				{
					if(BlackCheck[i][j]) protectedPiecesBlack[i][j] = true; 
					else protectedPiecesBlack[i][j] = false; 
					BlackCheck[i][j] = true;
					pieces.CheckingCheck(BlackCheck, i, j, PiecesPosition[i][j]);
					if(PiecesPosition[i][j] == 7 && i + 1 < PiecesPosition.length)
					{
						if(PiecesPosition[i + 1][j] == 0)
						BlackCheck[i + 1][j] = false;
					}
				}	
			}
		
		for (int i = WhiteCheck.length - 1; i >= 0; i--)
			for (int j = WhiteCheck.length - 1; j >= 0; j--)
			{
				if(PiecesPosition[i][j] > 6 && PiecesPosition[i][j] <= 12)
				{
					if(BlackCheck[i][j]) protectedPiecesBlack[i][j] = true; 
					else protectedPiecesBlack[i][j] = false; 
					BlackCheck[i][j] = true;
					pieces.CheckingCheck(BlackCheck, i, j, PiecesPosition[i][j]);
					if(PiecesPosition[i][j] == 7 && i + 1 < PiecesPosition.length)
					{
						if(PiecesPosition[i + 1][j] == 0)
						BlackCheck[i + 1][j] = false;
					}
				}	
			}
		//CheckPieces(BlackCheck);
		WhiteCheckCheck(BlackCheck);
		//ClearCheking(WhiteCheck);
	}
	
	public void ClearCheking(boolean[][] Checking_matris)
	{
		for (int i = 0; i < BlackCheck.length; i++) 
			for (int j = 0; j < BlackCheck.length; j++) Checking_matris[i][j] = false;
	}
	
	public void WhiteCheckCheck(boolean[][] path)
	{
		if(path[pieces.getWhiteKingPosition().x][pieces.getWhiteKingPosition().y]) 
		{
			System.out.println("Shah > Ag");
			CheckToWhite = true;;
		}
		else CheckToWhite = false;
	}
	
	public void BlackCheckCheck(boolean[][] path)
	{
		if(path[pieces.getBlackKingPosition().x][pieces.getBlackKingPosition().y]) 
		{
			System.out.println("Shah > Qara");
			CheckToBlack = true;;
		}
		else CheckToBlack = false;
		
	}
	
	
	//-----------------------------------
	
	public boolean isSideChanged() {
		return isSideChanged;
	}

	public void setSideChanged(boolean isSideChanged) {
		this.isSideChanged = isSideChanged;
	}

	public boolean[][] getWhiteCheck() {
		return WhiteCheck;
	}

	public void setWhiteCheck(boolean[][] whiteCheck) {
		WhiteCheck = whiteCheck;
	}

	public byte getWhiteCount() {
		return whiteCount;
	}

	public void setWhiteCount(byte whiteCount) {
		this.whiteCount = whiteCount;
	}

	public boolean isCheckToBlack() {
		return CheckToBlack;
	}

	public void setCheckToBlack(boolean checkToBlack) {
		CheckToBlack = checkToBlack;
	}

	public boolean isCheckToWhite() {
		return CheckToWhite;
	}

	public void setCheckToWhite(boolean checkToWhite) {
		CheckToWhite = checkToWhite;
	}

	
	
}
