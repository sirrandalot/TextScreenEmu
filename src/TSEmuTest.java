import javax.swing.JFrame;

import textScreenEmu.PaletteFactory;
import textScreenEmu.PalettePredef;
import textScreenEmu.Screen;
import textScreenEmu.TilesetFactory;
import textScreenEmu.TilesetPredef;

public class TSEmuTest {

	public static void main(String[] args){
		
		JFrame mainFrame = new JFrame();
		
		Screen s = new Screen(32, 16, 2, TilesetFactory.createTileset(TilesetPredef.CODEPAGE473_8x8), PaletteFactory.createPalette(PalettePredef.VGA_16));
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(9);
		
		//s.drawTile(1, 1, 2);
		
		//s.drawPalette(false);
		
		
		s.drawTileset(false);
		
		s.repaint();
		
		
	}
}
