package textScreenEmu;

/**
 * Class representing a set of Tiles.
 * @author sirrandalot
 *
 */
public class Tileset {

	/**
	 * The width of the tiles in this set.
	 */
	public final int tileWidth;
	
	/**
	 * The height of the tiles in this set.
	 */
	public final int tileHeight;
	
	/**
	 * The number of tiles in this set.
	 */
	public final int numTiles;
	
	/**
	 * The values of the tiles in this set.
	 */
	protected int[] values;
	
	
	/**
	 * Constructor for Tileset using tile width, tile height and number of tiles, calls another constructor using a zero array for values.
	 * @param tWidth The width of the tiles.
	 * @param tHeight The height of the tiles.
	 * @param numT The number of tiles.
	 */
	protected Tileset(int tWidth, int tHeight, int numT){
		this(tWidth, tHeight, numT, new int[tWidth*tHeight*numT]);
	}
	
	
	/**
	 * Constructor for Tileset using tile width, tile height, number of tiles and an array of values.
	 * @param tWidth The width of the tiles.
	 * @param tHeight The height of the tiles.
	 * @param numT The number of tiles.
	 * @param vals The values of the tiles.
	 */
	protected Tileset(int tWidth, int tHeight, int numT, int[] vals){
		
		//Check if the input values are appropriate
		try{
			
			if(tWidth <= 0 || tWidth > 512)
				throw new Exception("Width " + tWidth + " out of range, must be between 1 and 512 inclusively.");
			
			if(tHeight <= 0 || tHeight > 512)
				throw new Exception("Height " + tHeight + " out of range, must be between 1 and 512 inclusively.");
			
			if(numT <= 0 || numT > 1024)
				throw new Exception("Number of tiles " + numT + " out of range, must be between 1 and 1024 inclusively.");
			
			if(vals.length != tWidth*tHeight*numT)
				throw new Exception("Array length does not match width, height and num parameters, must be tWidth * tHeight * numT.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		tileWidth = tWidth;
		tileHeight = tHeight;
		numTiles = numT;
		
		values = vals.clone();
	}
	
	
	/**
	 * Constructor for Tileset using tile width and an array of Tiles.
	 * @param tWidth The width of the tiles.
	 * @param tHeight The height of the tiles.
	 * @param tiles The array of Tiles.
	 */
	protected Tileset(int tWidth, int tHeight, Tile[] tiles){
		
		//Check if the input values are appropriate
		try{
			
			if(tWidth <= 0 || tWidth > 512)
				throw new Exception("Width " + tWidth + " out of range, must be between 1 and 512 inclusively.");
			
			if(tHeight <= 0 || tHeight > 512)
				throw new Exception("Height " + tHeight + " out of range, must be between 1 and 512 inclusively.");
			
			if(tiles.length > 1024)
				throw new Exception("Number of tiles " + tiles.length + " out of range, must be between 1 and 1024 inclusively.");
			
			for(int i = 0; i < tiles.length; i++)
				if(tiles[i].tileWidth != tWidth || tiles[i].tileHeight != tHeight)
					throw new Exception("Tile size " + tiles[i].tileWidth + "x" + tiles[i].tileHeight + " does not match specified size: " + tWidth + "x" + tHeight + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		
		tileWidth = tWidth;
		tileHeight = tHeight;
		numTiles = tiles.length;
		
		values = new int[tileWidth*tileHeight*numTiles];
		
		for(int i = 0; i < tiles.length; i++)
			setTile(i, tiles[i]);
	}
	
	
	/**
	 * Sets the values for a tile at a specific index given an array for values.
	 * @param index The tile index.
	 * @param vals The values to use.
	 */
	public void setTile(int index, int[] vals){
		
		//Check if the input values are appropriate
		try{
			
			if(index < 0 || index >= numTiles)
				throw new Exception("Tile index " + index + " out of range, must be between 0 and " + (numTiles-1) + " inclusively.");
			
			if(vals.length != tileWidth*tileHeight)
				throw new Exception("Array length does not match tile width and height, must be " + tileWidth + " * " + tileHeight + " = " + (tileWidth*tileHeight) + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		for(int t = 0; t < vals.length; t++){
			values[index*tileWidth*tileHeight + t] = vals[t];
		}
		
	}
	
	
	/**
	 * Sets the values for a tile at a specific index given a tile.
	 * @param index The tile index.
	 * @param tile The tile whose values to use.
	 */
	public void setTile(int index, Tile tile){
		
		//Check if the input values are appropriate
		try{
			
			if(tile.tileWidth != tileWidth || tile.tileHeight != tileHeight)
				throw new Exception("Tile size " + tile.tileWidth + "x" + tile.tileHeight + " does not match specified size: " + tileWidth + "x" + tileHeight + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		setTile(index, tile.values);
	}
}
