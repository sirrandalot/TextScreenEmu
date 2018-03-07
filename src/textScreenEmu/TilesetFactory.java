package textScreenEmu;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class TilesetFactory {

	
	public static Tileset createTileset(int tileWidth, int tileHeight, int numT){
		return new Tileset(tileWidth, tileHeight, numT);
	}
	
	public static Tileset createTileset(int tileWidth, int tileHeight, int numT, int[] vals){
		return new Tileset(tileWidth, tileHeight, numT, vals);
	}
	
	public static Tileset createTileset(int tileWidth, int tileHeight, Tile[] tiles){
		return new Tileset(tileWidth, tileHeight, tiles);
	}
	
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
	
	
	private static Tileset makeTileset_Codepage473_9x16(){
		return getTilesetFromFile("cp437_9x16.png", 9, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Codepage473_8x8(){
		return getTilesetFromFile("cp437_8x8.png", 8, 8, 16, 16);
	}
	
	
	private static Tileset makeTileset_Codepage473_10x10(){
		return getTilesetFromFile("cp437_10x10.png", 10, 10, 16, 16);
	}
	
	
	private static Tileset makeTileset_Codepage473_12x12(){
		return getTilesetFromFile("cp437_12x12.png", 12, 12, 16, 16);
	}
	
	
	private static Tileset makeTileset_Codepage473_16x16(){
		return getTilesetFromFile("cp437_16x16.png", 16, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Simplemood_16x16(){
		return getTilesetFromFile("sm_16x16.png", 16, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Medieval_8x16(){
		return getTilesetFromFile("medieval_8x16.bmp", 8, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Broadway_8x16(){
		return getTilesetFromFile("broadway_8x16.bmp", 8, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Antique_8x16(){
		return getTilesetFromFile("antique_8x16.bmp", 8, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Courier_8x16(){
		return getTilesetFromFile("courier_8x16.bmp", 8, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Retro_10x10(){
		return getTilesetFromFile("retro_10x10.png", 10, 10, 16, 16);
	}
	
	
	private static Tileset makeTileset_Basic_8x8(){
		return getTilesetFromFile("basic_8x8.png", 8, 8, 16, 16);
	}
	
	
	private static Tileset makeTileset_Comicsans_16x16(){
		return getTilesetFromFile("comicsans_16x16.png", 16, 16, 16, 16);
	}
	
	
	private static Tileset makeTileset_Doodle_6x6(){
		return getTilesetFromFile("doodle_6x6.png", 6, 6, 16, 16);
	}
	
	
	private static Tileset makeTileset_Doodle_16x16(){
		return getTilesetFromFile("doodle_16x16.png", 16, 16, 16, 16);
	}
	
	
	private static Tileset getTilesetFromFile(String name, int tileWidth, int tileHeight, int numX, int numY){
		BufferedImage img = null;
		
		try{
			
			img = ImageIO.read(TilesetFactory.class.getResource("/textScreenEmu/images/" + name));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getTilesetFromImage(img, tileWidth, tileHeight, numX, numY);
	}
	
	public static Tileset getTilesetFromImage(BufferedImage img, int tileWidth, int tileHeight, int numX, int numY){
		
		try{
			
			if(img.getWidth() != tileWidth*numX)
				throw new Exception("Image width " + img.getWidth() + " does not match tile width and number of x tiles " + tileWidth + " and " + numX + ".");
			
			if(img.getHeight() != tileHeight*numY)
				throw new Exception("Image height " + img.getHeight() + " does not match tile width and number of x tiles " + tileHeight + " and " + numY + ".");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		int[] values = new int[img.getWidth()*img.getHeight()];
		int c = 0;
		
		for(int ty = 0; ty < numY; ty++){
			for(int tx = 0; tx < numX; tx++){
				
				for(int j = 0; j < tileHeight; j++){
					for(int i = 0; i < tileWidth; i++){
						
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
