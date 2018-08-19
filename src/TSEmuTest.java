import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import textScreenEmu.ASCIIname;
import textScreenEmu.Palette;
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
		PalettePredef plPredef = PalettePredef.APPLEII_16;
		
		//Palette pal = PaletteFactory.createPalette(plPredef);
		
		s = new Screen(16, 16, 2, TilesetFactory.createTileset(tsPredef), PaletteFactory.createPalette(plPredef));
		//s = new Screen(8, 1, 1, TilesetFactory.createTileset(1, 1, 2, new int[]{0, 1}), pal);
		
		mainFrame.add(s);
		
		mainFrame.setResizable(false);
		
		mainFrame.pack();
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setVisible(true);
		
		
		s.clearScreen();
		
		s.setForegroundColour(7);
		
		s.drawTile(1, 1, 2);
		s.drawRandomTile(2, 2, (long)(Math.random()*100000.0));
		
		s.setBackgroundColour(4);
		
		s.drawTile(5, 5, ASCIIname.LETTER_i_UMLAUT);
		s.drawTile(5, 6, ASCIIname.AMPERSAND);
		s.drawTile(5, 7, ASCIIname.ARROW_VERTICAL_LINE);
		s.drawTile(5, 8, ASCIIname.LETTER_A_RING);
		
		s.drawTile(8, 5, ASCIIname.LETTER_i_UMLAUT);
		s.drawTile(8, 6, ASCIIname.AMPERSAND);
		s.drawTile(8, 7, ASCIIname.ARROW_VERTICAL_LINE);
		s.drawTile(8, 8, ASCIIname.LETTER_A_RING);
		
		s.setColours(6, 9);
		
		s.drawTile(6, 5, ASCIIname.DIVIDE);
		s.drawTile(6, 6, ASCIIname.FRACTION_QUARTER);
		s.drawTile(6, 7, ASCIIname.GREEK_PHI_UPPER);
		s.drawTile(6, 8, ASCIIname.APPROXIMATION);
		
		
		//s.useSameBackground(true);
		s.setBackgroundColour(-1);
		
		s.drawTile(8, 5, ASCIIname.DIVIDE);
		
		//s.useSameBackground(false);
		s.setBackgroundColour(6);
		//s.useSameForeground(true);
		s.setForegroundColour(-1);
		
		s.drawTile(8, 6, ASCIIname.FRACTION_QUARTER);
		
		//s.useSameBackground(true);
		s.setBackgroundColour(-1);
		
		s.drawTile(8, 7, ASCIIname.GREEK_PHI_UPPER);
		
		//s.useSameBackground(false);
		//s.useSameForeground(false);
		s.setColours(6, 9);
		
		s.drawTile(8, 8, ASCIIname.APPROXIMATION);
		
		s.setColours(7, 10);
		
		for(int i = 0; i < 10; i++){
			s.drawGarbageTile(10, 3 + i, (long)(Math.random()*100000.0));
		}
		
		s.setColours(8, 11);
		
		s.drawTile(6,  12, ASCIIname.LETTER_R);
		s.setColours(9, 12);
		s.drawTile(7,  12, ASCIIname.LETTER_R, true, false);
		s.drawTile(6,  13, ASCIIname.LETTER_R, false, true);
		s.setColours(8, 11);
		s.drawTile(7,  13, ASCIIname.LETTER_R, true, true);
		
		//s.drawTileset(false);
		
		s.drawPalette(false);
		
		
		
//		Field[] fields = ASCIIname.class.getDeclaredFields();
//		
//		int c = 0;
//		
//		for(Field f : fields){
//			System.out.println(c + ". " + f.getName());
//			
//			c++;
//			
//			if(c%16 == 0) System.out.println();
//		}
		
//		for(int i = 0; i < 10; i++){
//			s.drawRandomTile(i, i, i*((long)(Math.random()*5000)));
//		}
//		
//		s.drawTile(10,  2, '+');
//		
//		
//		s.setForegroundColour(3);
//		
//		s.drawString(2,  5,  "Testing sTrIng!!?? Testing out this new draw string feature man this is pretty cool but I have to keep writing in order to test it properly.", true, true);
		
		
		s.repaint();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		
//		File outputfile = new File("Tileset_" + tsPredef.toString() + ".png");
//        try {
//			ImageIO.write(s.BIScaled, "png", outputfile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	}
}
