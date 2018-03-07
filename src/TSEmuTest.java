import javax.swing.JFrame;

import textScreenEmu.PaletteFactory;
import textScreenEmu.PalettePredef;
import textScreenEmu.Screen;
import textScreenEmu.TilesetFactory;
import textScreenEmu.TilesetPredef;

public class TSEmuTest {

	public static void main(String[] args){
		
		JFrame mainFrame = new JFrame();
		
		Screen s = new Screen(32, 16, 2, TilesetFactory.createTileset(TilesetPredef.ANTIQUE_8x16), PaletteFactory.createPalette(PalettePredef.PHOSPHOR_8));
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(3);
		
		//s.drawTile(1, 1, 2);
		
		s.drawTileset(false);
		
		//s.drawPalette(false);
		
		
		
		
		s.repaint();
		
		
	}
}
