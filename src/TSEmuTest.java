import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import textScreenEmu.PaletteFactory;
import textScreenEmu.PalettePredef;
import textScreenEmu.Screen;
import textScreenEmu.TilesetFactory;
import textScreenEmu.TilesetPredef;

public class TSEmuTest {

	public static void main(String[] args){
		
		JFrame mainFrame = new JFrame();
		
		Screen s;
		
		TilesetPredef tsPredef = TilesetPredef.CODEPAGE437_16x16;
		PalettePredef plPredef = PalettePredef.PHOSPHOR_8;
		
		s = new Screen(32, 16, 2, TilesetFactory.createTileset(tsPredef), PaletteFactory.createPalette(plPredef));
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(7);
		
		//s.drawTile(1, 1, 2);
		
		s.drawTileset(false);
		
		//s.drawPalette(false);
		
		
		
		
		s.repaint();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		
//		File outputfile = new File("Palette_" + plPredef.toString() + ".png");
//        try {
//			ImageIO.write(s.BIScaled, "png", outputfile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	}
}
