package textScreenEmu.tilesets;

public class Tile {

	private int[] values;
	
	public final int tileWidth;
	public final int tileHeight;
	
	public Tile(int width, int height){
		
		try{
			
			if(width <= 0 || width > 512)
				throw new Exception("Width " + width + " out of range, must be between 1 and 512.");
			
			if(height <= 0 || height > 512)
				throw new Exception("Height " + height + " out of range, must be between 1 and 512.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		tileWidth = width;
		tileHeight = height;
		
		values = new int[tileWidth * tileHeight];
	}
}
