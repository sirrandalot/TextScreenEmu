package textScreenEmu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Class which emulates a screen by extending a JPanel and drawing to a scaled BufferedImage.
 * @author sirrandalot
 *
 */
public class Screen extends JPanel{
	
	/**
	 * Default serial UID, needed becuase JPanel implements Serializable.
	 * Not really necessary but gets rid of compiler warning.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The image to which everything will be drawn.
	 */
	private BufferedImage BI;
	
	/**
	 * The image which will be drawn to the panel.
	 */
	private BufferedImage BIScaled;
	
	/**
	 * How much to scale the base image.
	 */
	public final int imageScale;
	
	/**
	 * The horizontal number of tiles in the screen.
	 */
	public final int numTilesX;
	
	/**
	 * The vertical number of tiles in the screen.
	 */
	public final int numTilesY;
	
	/**
	 * The indices representing the background and foreground colours.
	 */
	private int[] colourIndices = {0, 1};
	
	/**
	 * the Tileset to use.
	 */
	public Tileset tileset;
	
	/**
	 * The colour palette to use.
	 */
	public Palette palette;
	
	/**
	 * Whether or not to draw using the background colour that was most
	 * recently drawn at a given position.
	 */
	private boolean[] useSameColour = {false, false};
	
	/**
	 * Hold the most recently used values for foreground and background colours.
	 */
	private int[][] tileColours;
	
	
	/**
	 * Constructor for Screen.
	 * @param numTx The horizontal number of tiles.
	 * @param numTy The vertical number of tiles.
	 * @param scale The scale of the screen.
	 * @param t The Tileset to use.
	 * @param p The Palette to use.
	 */
	public Screen(int numTx, int numTy, int scale, Tileset t, Palette p){
		
		int nx = numTx;
		int ny = numTy;
		int s = scale;
		
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
			
			nx = 16;
			ny = 16;
			s = 2;
		}
		
		numTilesX = nx;
		numTilesY = ny;
		imageScale = s;
		
		tileset = t;
		palette = p;
		
		BI = new BufferedImage(numTilesX*tileset.tileWidth, numTilesY*tileset.tileHeight, BufferedImage.TYPE_INT_RGB);
		BIScaled = new BufferedImage(numTilesX*tileset.tileWidth*imageScale, numTilesY*tileset.tileHeight*imageScale, BufferedImage.TYPE_INT_RGB);
		
		this.setPreferredSize(new Dimension(numTilesX*tileset.tileWidth*imageScale, numTilesY*tileset.tileHeight*imageScale));
		
		tileColours = new int[numTilesX*numTilesY][2];
		
		clearScreen();
	}
	
	
	/**
	 * Colours the entire screen with the current background colour.
	 */
	public void clearScreen(){
		
		//Set all pixels to background colour
		for(int i = 0; i < BI.getWidth(); i++){
			for(int j = 0; j < BI.getHeight(); j++){
				BI.setRGB(i, j, palette.colours[colourIndices[0]]);
			}
		}
		
		for(int i = 0; i < tileColours.length; i++){
			tileColours[i][0] = colourIndices[0];
			tileColours[i][1] = colourIndices[1];
		}
	}
	
	
	/**
	 * Sets the foreground colour.
	 * @param index The new colour index.
	 * @return True if the colour was set successfully, false otherwise.
	 */
	public boolean setForegroundColour(int index){
		if(index >= 0 && index < palette.getNumColours()){
			colourIndices[1] = index;
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Sets the background colour, -1 for "transparent".
	 * @param index The new colour index.
	 * @return True if the colour was set successfully, false otherwise.
	 */
	public boolean setBackgroundColour(int index){
		if(index >= 0 && index < palette.getNumColours()){
			colourIndices[0] = index;
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Sets whether or not to use the most recently used background colour for a tile position
	 * when drawing a tile.
	 * @param use Whether or not to use the previous background colour of a tile.
	 */
	public void useSameBackground(boolean use){
		useSameColour[0] = use;
	}
	
	
	/**
	 * Sets whether or not to use the most recently used foreground colour for a tile position
	 * when drawing a tile.
	 * @param use Whether or not to use the previous foreground colour of a tile.
	 */
	public void useSameForeground(boolean use){
		useSameColour[1] = use;
	}
	
	
	/**
	 * Sets both the foreground and background colour.
	 * @param indexBackground The new background colour index.
	 * @param indexForeground The new foreground colour index.
	 * @return True if the colour was set successfully, false otherwise (for both background and foreground).
	 */
	public boolean[] setColours(int indexBackground, int indexForeground){
		return new boolean[]{setBackgroundColour(indexBackground), setForegroundColour(indexForeground)};
	}
	
	
	/**
	 * Draws a specified tile at a tile position.
	 * @param x The x position.
	 * @param y The y position.
	 * @param tile The index of the tile to draw.
	 * @return True if the tile was drawn, false if it was out of bounds.
	 */
	public boolean drawTile(int x, int y, int tile){
		if(x < 0 || x > numTilesX-1 || y < 0 || y > numTilesY-1 || tile < 0 || tile > tileset.numTiles-1){
			return false;
		}
		
		int[] tempCol = {colourIndices[0], colourIndices[1]};
		
		//Use the most recent colours of this tile if we're supposed to
		for(int t = 0; t < 2; t++)
			if(useSameColour[t])
				colourIndices[t] = tileColours[y*numTilesX + x][t];
			
		
		
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
		
		//Keep track of what colours were used to draw this tile
		tileColours[y*numTilesX + x][0] = colourIndices[0];
		tileColours[y*numTilesX + x][1] = colourIndices[1];

		for(int t = 0; t < 2; t++)
			if(useSameColour[t])
				colourIndices[t] = tempCol[t];
		
		
		return true;
	}
	
	
	/**
	 * Draws a (seeded) random tile at a tile position.
	 * @param x The x position.
	 * @param y The y position.
	 * @param seed The seed for the random tile number.
	 * @return True if the tile was draw, false if it was out of bounds.
	 */
	public boolean drawRandomTile(int x, int y, long seed){
		Random r = new Random(seed);
		
		return drawTile(x, y, r.nextInt(tileset.numTiles));
	}
	
	
	/**
	 * Draws a String to the screen starting at a given position, assuming the tileset uses typical ASCII values.
	 * @param x The starting x position.
	 * @param y The starting y position.
	 * @param s The string to draw.
	 * @param wrapX If true, wraps the string horizontally.
	 * @param wrapOnSpace If true, tries to wrap the string at spaces.
	 */
	public void drawString(int x, int y, String s, boolean wrapX, boolean wrapOnSpace){

		int xp = x;
		int yp = y;
		
		if(wrapX && x < 0)
			xp = 0;
		
		
		for(int c = 0; c < s.length(); c++){
			if(wrapX && xp >= numTilesX){
				yp++;
				xp = 0;
				
				if(s.charAt(c) == ' ') continue;
			}
			
			if(!wrapX || !wrapOnSpace || s.charAt(c) != ' '){
				drawTile(xp, yp, s.charAt(c));
			}else{
				if(noMoreSpaces(s, c, c-xp+numTilesX)){
					yp++;
					xp = 0;
					continue;
				}
			}
			
			
			xp++;
		}
		
	}
	
	
	/**
	 * Checks if there are any more spaces on the current line of text (if the string extends past the end of the line).
	 * @param s The string.
	 * @param startSpace The index of the current space.
	 * @param end The index of the end of the line.
	 * @return True if there are no more spaces on teh line, false otherwise or if the string doesn't extend past the end of the line anyways.
	 */
	private boolean noMoreSpaces(String s, int startSpace, int end){
		
		if(s.length() < end)
			return false;
		
		for(int i = startSpace+1; i < end; i++){
			if(s.charAt(i) == ' ')
				return false;
		}
		
		return true;
	}
	
	
	/**
	 * Draws the current Tileset.
	 * @param flat If true, wraps at screen width, otherwise wraps at 16.
	 */
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
	
	
	/**
	 * Draws the current palette.
	 * @param flat If true, wraps at screen width, otherwise wraps at 16.
	 */
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
	
	
	/**
	 * Scales the BufferedImage and then draws it to the panel.
	 */
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
