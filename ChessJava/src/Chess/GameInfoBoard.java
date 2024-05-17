package Chess;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GameInfoBoard extends JPanel 
{
	public GameInfoBoard(int panelWidth, int panelHeigh) {
		setPreferredSize(new Dimension(panelWidth, panelHeigh));
		setBackground(new Color(140,140,140));
	}
}
