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
		default:
			System.out.println("Enum value not recognized, returning classic 8x16 tileset...");
			return makeTileset_Codepage473_9x16();
		}
	}
	
	
	
	private static Tileset makeTileset_Codepage473_9x16(){
		return new Tileset(9, 16, new Tile[]{
				new Tile(9, 16),
				new Tile(9, 16, new int[]{
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 1, 1, 1, 1, 1, 1, 0, 0,
						1, 0, 0, 0, 0, 0, 0, 1, 0,
						1, 0, 1, 0, 0, 1, 0, 1, 0,
						1, 0, 0, 0, 0, 0, 0, 1, 0,
						1, 0, 0, 0, 0, 0, 0, 1, 0,
						1, 0, 1, 1, 1, 1, 0, 1, 0,
						1, 0, 0, 1, 1, 0, 0, 1, 0,
						1, 0, 0, 0, 0, 0, 0, 1, 0,
						1, 0, 0, 0, 0, 0, 0, 1, 0,
						0, 1, 1, 1, 1, 1, 1, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0
				}),
				new Tile(9, 16, new int[]{
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 1, 1, 1, 1, 1, 1, 0, 0,
						1, 1, 1, 1, 1, 1, 1, 1, 0,
						1, 1, 0, 1, 1, 0, 1, 1, 0,
						1, 1, 1, 1, 1, 1, 1, 1, 0,
						1, 1, 1, 1, 1, 1, 1, 1, 0,
						1, 1, 0, 0, 0, 0, 1, 1, 0,
						1, 1, 1, 0, 0, 1, 1, 1, 0,
						1, 1, 1, 1, 1, 1, 1, 1, 0,
						1, 1, 1, 1, 1, 1, 1, 1, 0,
						0, 1, 1, 1, 1, 1, 1, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0
				})
		});
	}
}
