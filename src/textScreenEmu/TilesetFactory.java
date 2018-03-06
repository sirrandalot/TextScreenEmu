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
		case CLASSIC_9x14:
			return makeTileset_Classic9x14();
		default:
			System.out.println("Enum value not recognized, returning classic 9x14 tileset...");
			return makeTileset_Classic9x14();
		}
	}
	
	
	
	private static Tileset makeTileset_Classic9x14(){
		return new Tileset(9, 14, new Tile[]{
				new Tile(9, 14)
		});
	}
}
