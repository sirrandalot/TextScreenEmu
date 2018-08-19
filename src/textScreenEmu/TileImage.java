package textScreenEmu;

/**
 * 
 * @author sirrandalot
 *
 */
public class TileImage {
	
	/**
	 * The number of horizontal tiles in the image.
	 */
	public final int imageWidth;
	
	/**
	 * The number of vertical tiles in the image.
	 */
	public final int imageHeight;
	
	/**
	 * The values for all the tiles.
	 */
	protected int[] tileValues;
	
	/**
	 * The foreground and background colour values for all the tiles.
	 */
	protected int[][] colourValues;
	
	
	/**
	 * Constructor taking the width and height of the image.
	 * Creates a totally blank image with default 0 values.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 */
	public TileImage(int width, int height){
		this(width, height, new int[width*height], new int[width*height][2]);
	}
	
	
	/**
	 * Creates a TileImage using the width and height, an array of tile values and
	 * an array of background and foreground colour values.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @param vals The tile values.
	 * @param cols The colour values.
	 */
	public TileImage(int width, int height, int[] vals, int[][] cols){
		
		//Check if the input values are appropriate
		try{
			if(width <= 0 || height <= 0)
				throw new Exception("Width and height must be greater than 0.");
			
			if(vals.length != width*height)
				throw new Exception("Wrong number of tile values: " + vals.length + ", must be " + (width*height) + ".");
			
			if(cols.length != width*height)
				throw new Exception("Wrong number of colour values: " + cols.length + ", must be " + (width*height) + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		imageWidth = width;
		imageHeight = height;
		
		tileValues = vals.clone();
		
		colourValues = new int[width*height][2];
		for(int i = 0; i < cols.length; i++)
			colourValues[i] = new int[]{cols[i][0], cols[i][1]};
	}
	
	/**
	 * Sets the value and colours of a tile at a given position.
	 * @param x The x position of the tile.
	 * @param y The y position of the tile.
	 * @param val The value to set.
	 * @param background The background colour to set.
	 * @param foreground The foreground colour to set.
	 */
	public void setTile(int x, int y, int val, int background, int foreground){
		setTileValue(x, y, val);
		setTileColour(x, y, background, foreground);
	}
	
	/**
	 * Sets the value of a tile at a given position.
	 * @param x The x position of the tile.
	 * @param y The y position of the tile.
	 * @param val The value to set.
	 */
	public void setTileValue(int x, int y, int val){
		
		//Check if the input values are appropriate
		try{
			
			if(x < 0 || x >= imageWidth)
				throw new Exception("X position " + x + " out of range, must be between 0 and " + (imageWidth-1) + " inclusively.");
			
			if(y < 0 || y >= imageHeight)
				throw new Exception("Y position " + y + " out of range, must be between 0 and " + (imageHeight-1) + " inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		tileValues[y*imageWidth + x] = val;
	}
	
	/**
	 * Sets the colours of a tile at a given position.
	 * @param x The x position of the tile.
	 * @param y The y position of the tile.
	 * @param background The background colour to set.
	 * @param foreground The foreground colour to set.
	 */
	public void setTileColour(int x, int y, int background, int foreground){
		
		//Check if the input values are appropriate
		try{
			
			if(x < 0 || x >= imageWidth)
				throw new Exception("X position " + x + " out of range, must be between 0 and " + (imageWidth-1) + " inclusively.");
			
			if(y < 0 || y >= imageHeight)
				throw new Exception("Y position " + y + " out of range, must be between 0 and " + (imageHeight-1) + " inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		colourValues[y*imageWidth + x] = new int[]{background, foreground};
	}
	
	
	/**
	 * Gets the tile value at a specified position.
	 * @param x The x position.
	 * @param y The y position.
	 * @return The tile value.
	 */
	public int getTileValue(int x, int y){
		
		//Check if the input values are appropriate
		try{
			
			if(x < 0 || x >= imageWidth)
				throw new Exception("X position " + x + " out of range, must be between 0 and " + (imageWidth-1) + " inclusively.");
			
			if(y < 0 || y >= imageHeight)
				throw new Exception("Y position " + y + " out of range, must be between 0 and " + (imageHeight-1) + " inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		return tileValues[y*imageWidth + x];
	}
	
	
	/**
	 * Gets the background and foreground colours of a tile ad a specified position.
	 * @param x The x position.
	 * @param y The y position.
	 * @return The background and foreground colours.
	 */
	public int[] getTileColours(int x, int y){
		
		//Check if the input values are appropriate
		try{
			
			if(x < 0 || x >= imageWidth)
				throw new Exception("X position " + x + " out of range, must be between 0 and " + (imageWidth-1) + " inclusively.");
			
			if(y < 0 || y >= imageHeight)
				throw new Exception("Y position " + y + " out of range, must be between 0 and " + (imageHeight-1) + " inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		return colourValues[y*imageWidth + x].clone();
	}
}
