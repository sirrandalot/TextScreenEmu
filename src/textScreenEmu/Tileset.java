package textScreenEmu;

public class Tileset {

	public final int tileWidth;
	
	public final int tileHeight;
	
	public final int numTiles;
	
	protected int[] values;
	
	
	protected Tileset(int tWidth, int tHeight, int numT){
		this(tWidth, tHeight, numT, new int[tWidth*tHeight*numT]);
	}
	
	
	protected Tileset(int tWidth, int tHeight, int numT, int[] vals){
		
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
	
	
	protected Tileset(int tWidth, int tHeight, Tile[] tiles){
		
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
		
		for(int i = 0; i < tiles.length; i++){
			for(int t = 0; t < tileWidth*tileHeight; t++){
				values[i*tileWidth*tileHeight + t] = tiles[i].values[t];
			}
		}
	}
	
	
	public void setTile(int index, int[] vals){
		
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
	
	public void setTile(int index, Tile tile){
		
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
