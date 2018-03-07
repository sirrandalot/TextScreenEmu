import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
		
		Screen s = new Screen(32, 16, 2, TilesetFactory.createTileset(TilesetPredef.CODEPAGE473_8x8), PaletteFactory.createPalette(PalettePredef.VGA_16));
		
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
		
		//getDataFromImage("cp437_9x16", 9, 16);
		//getDataFromImage("cp437_8x8", 8, 8);
		//getDataFromImage("cp437_10x10", 10, 10);
		//getDataFromImage("cp437_12x12", 12, 12);
		//getDataFromImage("cp437_16x16", 16, 16);
		
	}
	
	public static BufferedImage getDataFromImage(String name, int x, int y){
		BufferedImage buf = null;
		
		try{
			buf = ImageIO.read(new File("C:/Users/puric/Desktop/PictureStuff/Tilesets/" + name + ".png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter writer = new PrintWriter("C:/Users/puric/Desktop/PictureStuff/Tilesets/" + name + ".txt", "UTF-8");
			
			for(int ty = 0; ty < 16; ty++){
				for(int tx = 0; tx < 16; tx++){
					writer.print("new Tile(" + x + ", " + y + ", " + "new int[]{\n");
					
					for(int j = 0; j < y; j++){
						for(int i = 0; i < x; i++){
							
							int r = buf.getRGB(x*tx + i, y*ty + j) & 0xFF;
							
							if(r > 0)
								writer.print(1);
							else
								writer.print(0);
							
							if(i != x-1 || j != y-1)
								writer.print(", ");
						}
						writer.print("\n");
					}
					
					
					writer.print("})");
					
					if(ty != 15 || tx != 15)
						writer.print(",\n");
						
				}
			}
			
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return buf;
	}
}
