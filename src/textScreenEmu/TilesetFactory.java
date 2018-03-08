package textScreenEmu;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * Factory class for creating Tilesets.
 * @author sirrandalot
 *
 */
public class TilesetFactory {

	/**
	 * Creates a blank Tileset given a tile width, height and a number of Tiles.
	 * @param tileWidth The width of the tiles.
	 * @param tileHeight The height of the tiles.
	 * @param numT The number of tiles.
	 * @return A blank Tileset.
	 */
	public static Tileset createTileset(int tileWidth, int tileHeight, int numT){
		return new Tileset(tileWidth, tileHeight, numT);
	}
	
	/**
	 * Creates a tileset given a tile width, height, number of tiles and an array of values.
	 * @param tileWidth The width of the tiles.
	 * @param tileHeight The height of the tiles.
	 * @param numT The number of tiles.
	 * @param vals The values for the Tileset.
	 * @return A Tileset using the provided values.
	 */
	public static Tileset createTileset(int tileWidth, int tileHeight, int numT, int[] vals){
		return new Tileset(tileWidth, tileHeight, numT, vals);
	}
	
	/**
	 * Creates a tileset given a tile width, height, and an array of Tiles.
	 * @param tileWidth The width of the tiles.
	 * @param tileHeight The height of the tiles.
	 * @param tiles The Tile array.
	 * @return A Tileset using the provided Tiles.
	 */
	public static Tileset createTileset(int tileWidth, int tileHeight, Tile[] tiles){
		return new Tileset(tileWidth, tileHeight, tiles);
	}
	
	/**
	 * Creates a pre-defined Tileset given a TilesetPredef enum value.
	 * @param t The TilesetPredef enum value.
	 * @return A pre-defined Tileset.
	 */
	public static Tileset createTileset(TilesetPredef t){
		
		switch(t){
		case CODEPAGE473_9x16:
			return makeTileset_Codepage473_9x16();
		case CODEPAGE473_8x8:
			return makeTileset_Codepage473_8x8();
		case CODEPAGE473_10x10:
			return makeTileset_Codepage473_10x10();
		case CODEPAGE473_12x12:
			return makeTileset_Codepage473_12x12();
		case CODEPAGE473_16x16:
			return makeTileset_Codepage473_16x16();
		case SIMPLEMOOD_16x16:
			return makeTileset_Simplemood_16x16();
		case MEDIEVAL_8x16:
			return makeTileset_Medieval_8x16();
		case BROADWAY_8x16:
			return makeTileset_Broadway_8x16();
		case ANTIQUE_8x16:
			return makeTileset_Antique_8x16();
		case COURIER_8x16:
			return makeTileset_Courier_8x16();
		case RETRO_10x10:
			return makeTileset_Retro_10x10();
		case BASIC_8x8:
			return makeTileset_Basic_8x8();
		case COMICSANS_16x16:
			return makeTileset_Comicsans_16x16();
		case DOODLE_6x6:
			return makeTileset_Doodle_6x6();
		case DOODLE_16x16:
			return makeTileset_Doodle_16x16();
		default:
			System.out.println("Enum value not recognized, returning classic 9x16 tileset...");
			return makeTileset_Codepage473_9x16();
		}
	}
	
	/**
	 * Creates a "CodePage 473" 9x16 Tileset.
	 * @return A "CodePage 473" 9x16 Tileset.
	 */
	private static Tileset makeTileset_Codepage473_9x16(){
		return getTilesetFromFile("cp437_9x16.png", 9, 16, 16, 16);
	}
	
	/**
	 * Creates a "CodePage 473" 8x8 Tileset.
	 * @return A "CodePage 473" 8x8 Tileset.
	 */
	private static Tileset makeTileset_Codepage473_8x8(){
		return getTilesetFromFile("cp437_8x8.png", 8, 8, 16, 16);
	}
	
	/**
	 * Creates a "CodePage 473" 10x10 Tileset.
	 * @return A "CodePage 473" 10x10 Tileset.
	 */
	private static Tileset makeTileset_Codepage473_10x10(){
		return getTilesetFromFile("cp437_10x10.png", 10, 10, 16, 16);
	}
	
	/**
	 * Creates a "CodePage 473" 12x12 Tileset.
	 * @return A "CodePage 473" 12x12 Tileset.
	 */
	private static Tileset makeTileset_Codepage473_12x12(){
		return getTilesetFromFile("cp437_12x12.png", 12, 12, 16, 16);
	}
	
	/**
	 * Creates a "CodePage 473" 16x16 Tileset.
	 * @return A "CodePage 473" 16x16 Tileset.
	 */
	private static Tileset makeTileset_Codepage473_16x16(){
		return getTilesetFromFile("cp437_16x16.png", 16, 16, 16, 16);
	}
	
	/**
	 * Creates a "Simple Mood" 16x16 Tileset.
	 * @return A "Simple Mood" 16x16 Tileset.
	 */
	private static Tileset makeTileset_Simplemood_16x16(){
		return getTilesetFromFile("sm_16x16.png", 16, 16, 16, 16);
	}
	
	/**
	 * Creates a "Medieval" 8x16 Tileset.
	 * @return A "Medieval" 8x16 Tileset.
	 */
	private static Tileset makeTileset_Medieval_8x16(){
		return getTilesetFromFile("medieval_8x16.bmp", 8, 16, 16, 16);
	}
	
	/**
	 * Creates a "Broadway" 8x16 Tileset.
	 * @return A "Broadway" 8x16 Tileset.
	 */
	private static Tileset makeTileset_Broadway_8x16(){
		return getTilesetFromFile("broadway_8x16.bmp", 8, 16, 16, 16);
	}
	
	/**
	 * Creates a "Antique" 8x16 Tileset.
	 * @return A "Antique" 8x16 Tileset.
	 */
	private static Tileset makeTileset_Antique_8x16(){
		return getTilesetFromFile("antique_8x16.bmp", 8, 16, 16, 16);
	}
	
	/**
	 * Creates a "Courier" 8x16 Tileset.
	 * @return A "Courier" 8x16 Tileset.
	 */
	private static Tileset makeTileset_Courier_8x16(){
		return getTilesetFromFile("courier_8x16.bmp", 8, 16, 16, 16);
	}
	
	/**
	 * Creates a "Retro" 10x10 Tileset.
	 * @return A "Retro" 10x10 Tileset.
	 */
	private static Tileset makeTileset_Retro_10x10(){
		return getTilesetFromFile("retro_10x10.png", 10, 10, 16, 16);
	}
	
	/**
	 * Creates a "Basic" 8x8 Tileset.
	 * @return A "Basic" 8x8 Tileset.
	 */
	private static Tileset makeTileset_Basic_8x8(){
		return getTilesetFromFile("basic_8x8.png", 8, 8, 16, 16);
	}
	
	/**
	 * Creates a "Comic Sans" 16x16 Tileset.
	 * @return A "Comic Sans" 16x16 Tileset.
	 */
	private static Tileset makeTileset_Comicsans_16x16(){
		return getTilesetFromFile("comicsans_16x16.png", 16, 16, 16, 16);
	}
	
	/**
	 * Creates a "Doodle" 6x6 Tileset.
	 * @return A "Doodle" 6x6 Tileset.
	 */
	private static Tileset makeTileset_Doodle_6x6(){
		return getTilesetFromFile("doodle_6x6.png", 6, 6, 16, 16);
	}
	
	/**
	 * Creates a "Doodle" 16x16 Tileset.
	 * @return A "Doodle" 16x16 Tileset.
	 */
	private static Tileset makeTileset_Doodle_16x16(){
		return getTilesetFromFile("doodle_16x16.png", 16, 16, 16, 16);
	}
	
	/**
	 * Creates a Tileset using an image saved inside the image package.
	 * @param name The file name.
	 * @param tileWidth The tile width.
	 * @param tileHeight The tile height.
	 * @param numX The number of horizontal tiles.
	 * @param numY The number of vertical tiles.
	 * @return A Tileset based off of a file in the image package.
	 */
	private static Tileset getTilesetFromFile(String name, int tileWidth, int tileHeight, int numX, int numY){
		BufferedImage img = null;
		
		try{
			
			img = ImageIO.read(TilesetFactory.class.getResource("/textScreenEmu/images/" + name));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getTilesetFromImage(img, tileWidth, tileHeight, numX, numY);
	}
	
	
	/**
	 * Creates a Tileset from a BufferedImage, the red value of pixels is used to determine
	 * whether or not to set the array value to 0 or 1, and a constant threshold is used.
	 * @param img The image to use.
	 * @param tileWidth The tile width.
	 * @param tileHeight The tile height.
	 * @param numX The number of horizontal tiles.
	 * @param numY The number of vertical tiles.
	 * @return A Tileset based off of the input image.
	 */
	public static Tileset getTilesetFromImage(BufferedImage img, int tileWidth, int tileHeight, int numX, int numY){
		
		//Check if the input parameters are appropriate
		try{
			
			if(img.getWidth() != tileWidth*numX)
				throw new Exception("Image width " + img.getWidth() + " does not match tile width and number of x tiles " + tileWidth + " and " + numX + ".");
			
			if(img.getHeight() != tileHeight*numY)
				throw new Exception("Image height " + img.getHeight() + " does not match tile width and number of x tiles " + tileHeight + " and " + numY + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		//Create an array to hold the values
		int[] values = new int[img.getWidth()*img.getHeight()];
		
		//Index counter
		int c = 0;
		
		//Iterate through the image
		for(int ty = 0; ty < numY; ty++){
			for(int tx = 0; tx < numX; tx++){
				
				for(int j = 0; j < tileHeight; j++){
					for(int i = 0; i < tileWidth; i++){
						
						//Check the red value of the pixel
						int r = img.getRGB(tileWidth*tx + i, tileHeight*ty + j) & 0xFF;
						
						if(r > 50)
							values[c] = 1;
						
						c++;
					}
				}
			}
		}
		
		
		return new Tileset(tileWidth, tileHeight, numX*numY, values);
	}

}
