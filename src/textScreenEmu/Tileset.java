package textScreenEmu;

public class Tileset {

	public final int tileWidth;
	
	public final int tileHeight;
	
	private int[] values;
	
	protected Tileset(int tWidth, int tHeight, int numTiles, int[] vals){
		
		try{
			
			if(tWidth <= 0 || tWidth > 512)
				throw new Exception("Width " + tWidth + " out of range, must be between 1 and 512.");
			
			if(tHeight <= 0 || tHeight > 512)
				throw new Exception("Height " + tHeight + " out of range, must be between 1 and 512.");
			
			if(numTiles <= 0 || numTiles > 1024)
				throw new Exception("Number of tiles " + numTiles + " out of range, must be between 1 and 1024.");
			
			if(vals.length != tWidth*tHeight*numTiles)
				throw new Exception("Array length does not match width, height and num parameters, must be tileWidth * tileHeight * numTiles.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		tileWidth = tWidth;
		tileHeight = tHeight;
	}
}
