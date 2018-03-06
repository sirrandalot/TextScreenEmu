package textScreenEmu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Screen extends JPanel{
	
	private BufferedImage BI;
	private BufferedImage BIScaled;
	
	public final int imageScale;
	
	public final int numTilesX;
	public final int numTilesY;
	
	private int[] colourIndices = {0, 1};
	
	public Tileset tileset;
	
	public Palette palette;
	
	
	public Screen(int numTx, int numTy, int scale, Tileset t, Palette p){
		
		try{
			
			if(numTx < 1 || numTx > 256)
				throw new Exception("Number of tiles X " + numTx + " out of range, must be between 1 and 256 inclusively.");
			
			if(numTy < 1 || numTy > 256)
				throw new Exception("Number of tiles Y " + numTy + " out of range, must be between 1 and 256 inclusively.");
			
			if(scale < 1 || scale > 16)
				throw new Exception("Image scale " + scale + " out of range, must be between 1 and 16 inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		numTilesX = numTx;
		numTilesY = numTy;
		imageScale = scale;
		
		tileset = t;
		palette = p;
		
		BI = new BufferedImage(numTilesX*tileset.tileWidth, numTilesY*tileset.tileHeight, BufferedImage.TYPE_INT_RGB);
		BIScaled = new BufferedImage(numTilesX*tileset.tileWidth*imageScale, numTilesY*tileset.tileHeight*imageScale, BufferedImage.TYPE_INT_RGB);
		
		this.setPreferredSize(new Dimension(numTilesX*tileset.tileWidth*imageScale, numTilesY*tileset.tileHeight*imageScale));
	}
	
	public void clearScreen(){

		for(int i = 0; i < BI.getWidth(); i++){
			for(int j = 0; j < BI.getHeight(); j++){
				BI.setRGB(i, j, palette.colours[colourIndices[0]]);
			}
		}
	}
	
	public boolean setForegroundColour(int index){
		if(index >= 0 && index < palette.getNumColours()){
			colourIndices[1] = index;
			return true;
		}
		
		return false;
	}
	
	public boolean setBackgroundColour(int index){
		if(index >= 0 && index < palette.getNumColours()){
			colourIndices[0] = index;
			return true;
		}
		
		return false;
	}
	
	public boolean[] setColour(int indexBackground, int indexForeground){
		return new boolean[]{setBackgroundColour(indexBackground), setForegroundColour(indexForeground)};
	}
	
	public boolean drawTile(int x, int y, int tile){
		if(x < 0 || x > numTilesX-1 || y < 0 || y > numTilesY-1 || tile < 0 || tile > tileset.numTiles-1){
			return false;
		}
		
		int offset = tile*tileset.tileWidth*tileset.tileHeight;
		
		int offX = x*tileset.tileWidth;
		int offY = y*tileset.tileHeight;
		
		int c = 0;
		
		for(int j = 0; j < tileset.tileHeight; j++){
			for(int i = 0; i < tileset.tileWidth; i++){
				BI.setRGB(offX + i, offY + j, palette.colours[colourIndices[tileset.values[offset+c]]]);
				c++;
			}
		}
		
		
		return true;
	}
	
	public void drawTileset(boolean flat){
		
		int c = 0;
		
		int x = 0;
		int y = 0;
		
		while(c < tileset.numTiles){
			
			drawTile(x, y, c);
			
			x++;
			
			if(flat){
				if(x == numTilesX){
					x = 0;
					y++;
				}
			}else{
				if(x == 16){
					x = 0;
					y++;
				}
			}
			
			c++;
		}
	}
	
	public void drawPalette(boolean flat){
		
		int c = 0;
		
		int x = 0;
		int y = 0;
		
		while(c < palette.getNumColours()){
			
			int offX = x*tileset.tileWidth;
			int offY = y*tileset.tileHeight;
			
			for(int j = 0; j < tileset.tileHeight; j++){
				for(int i = 0; i < tileset.tileWidth; i++){
					BI.setRGB(offX + i, offY + j, palette.colours[c]);
				}
			}
			
			x++;
			
			if(flat){
				if(x == numTilesX){
					x = 0;
					y++;
				}
			}else{
				if(x == 16){
					x = 0;
					y++;
				}
			}
			
			c++;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = BIScaled.createGraphics();
		
		//Scale by nearest neighbour
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		
		//Draw original imaged scaled up
		g2d.drawImage(BI, 0, 0, BIScaled.getWidth(), BIScaled.getHeight(), null);
		
		g2d.dispose();
		
		//Draw scaled image to panel
		g.drawImage(BIScaled, 0, 0, null);
	}
}
