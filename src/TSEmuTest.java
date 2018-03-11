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
		
		s = new Screen(16, 16, 2, TilesetFactory.createTileset(tsPredef), PaletteFactory.createPalette(plPredef));
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(7);
		
		//s.drawTile(1, 1, 2);
		
		//s.drawTileset(false);
		
		//s.drawPalette(false);
		
		for(int i = 0; i < 10; i++){
			s.drawRandomTile(i, i, i*((long)(Math.random()*5000)));
		}
		
		s.drawTile(10,  2, '+');
		
		
		s.setForegroundColour(3);
		
		s.drawString(2,  5,  "Testing sTrIng!!?? Testing out this new draw string feature man this is pretty cool but I have to keep writing in order to test it properly.", true, true);
		
		
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
