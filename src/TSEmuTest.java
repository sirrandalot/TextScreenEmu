import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		getDataFromImage("cp437_9x16", 9, 16);
		getDataFromImage("cp437_8x8", 8, 8);
		getDataFromImage("cp437_10x10", 10, 10);
		getDataFromImage("cp437_12x12", 12, 12);
		getDataFromImage("cp437_16x16", 16, 16);
		
	}
	
	public static BufferedImage getDataFromImage(String name, int x, int y){
		BufferedImage buf = null;
		
		try{
			buf = ImageIO.read(new File("C:/Users/puric/Desktop/PictureStuff/Tilesets/" + name + ".png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return buf;
	}
}
