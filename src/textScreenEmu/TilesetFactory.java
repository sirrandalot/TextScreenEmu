package textScreenEmu;

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
		default:
			System.out.println("Enum value not recognized, returning classic 9x16 tileset...");
			return makeTileset_Codepage473_9x16();
		}
	}
	
	

}
