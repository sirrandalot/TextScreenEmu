import javax.swing.JFrame;

import textScreenEmu.PaletteFactory;
import textScreenEmu.PalettePredef;
import textScreenEmu.Screen;
import textScreenEmu.TilesetFactory;
import textScreenEmu.TilesetPredef;

public class TSEmuTest {

	public static void main(String[] args){
		
		JFrame mainFrame = new JFrame();
		
		Screen s = new Screen(32, 8, 4, TilesetFactory.createTileset(TilesetPredef.CODEPAGE473_9x16), PaletteFactory.createPalette(PalettePredef.VGA_16));
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(7);
		
		//s.drawTile(1, 1, 2);
		
		//s.drawPalette(false);
		
		
		s.drawTileset(false);
		
		s.repaint();
		
	}
}
