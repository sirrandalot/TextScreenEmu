package textScreenEmu.tilesets;

public class Tile {

	/**
	 * The values of this tile.
	 */
	public int[] values;
	
	
	/**
	 * The width of this tile.
	 */
	public final int tileWidth;
	
	
	/**
	 * The height of this tile.
	 */
	public final int tileHeight;
	
	
	/**
	 * Constructor for the tile class using width, height and a value array.
	 * @param width The width to give this tile.
	 * @param height The height to give this tile.
	 * @param vals The values to give this tile.
	 */
	public Tile(int width, int height, int[] vals){
		
		//Check if the input values are appropriate
		try{
			
			if(width <= 0 || width > 512)
				throw new Exception("Width " + width + " out of range, must be between 1 and 512.");
			
			if(height <= 0 || height > 512)
				throw new Exception("Height " + height + " out of range, must be between 1 and 512.");
			
			if(vals.length != width*height)
				throw new Exception("Array length does not match width and height parameters, must be width * height.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		tileWidth = width;
		tileHeight = height;
		
		values = vals.clone();
	}
	
	/**
	 * Constructor for Tile class using just width and height, calls the other constructor with a blank array for values.
	 * @param width The width to give this tile.
	 * @param height The height to give this tile.
	 */
	public Tile(int width, int height){
		this(width, height, new int[width*height]);
	}
}
