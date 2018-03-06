package textScreenEmu;

/**
 * Class for creating Palettes.
 * @author sirrandalot
 *
 */
public class PaletteFactory {
	
	/**
	 * Creates a Palette using an integer array of colours.
	 * @param colours The colour array.
	 * @return A Palette using the colours provided.
	 */
	public static Palette createPalette(int[] colours){
		return new Palette(colours);
	}
	
	
	/**
	 * Creates a pre-defined Palette.
	 * @param p The PalettePredef enum value.
	 * @return A Palette based on the value given.
	 */
	public static Palette createPalette(PalettePredef p){
		
		switch(p){
		case BLACK_AND_WHITE:
			return makePalette_BlackAndWhite();
		case GREY_4:
			return makePalette_Grey4();
		case GREY_8:
			return makePalette_Grey8();
		case GREY_16:
			return makePalette_Grey16();
		case GREY_32:
			return makePalette_Grey32();
		case GREY_256:
			return makePalette_Grey256();
		case VGA_16:
			return makePalette_VGA16();
		case EGA_64:
			return makePalette_EGA64();
		case C64_16:
			return makePalette_C6416();
		case APPLEII_16:
			return makePalette_AppleII16();
		default:
			System.out.println("Enum value not recognized, returning black and white palette...");
			return makePalette_BlackAndWhite();
			
		}
	}
	
	/**
	 * Creates a 16 colour palette based on the Apple II colours.
	 * @return A Palette based on Apple II colours.
	 */
	private static Palette makePalette_AppleII16(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("00662239", 16),
				Integer.parseUnsignedInt("00383073", 16),
				Integer.parseUnsignedInt("00D932F8", 16),
				Integer.parseUnsignedInt("0019513B", 16),
				Integer.parseUnsignedInt("00767676", 16),
				Integer.parseUnsignedInt("001F94FA", 16),
				Integer.parseUnsignedInt("00B6ADFC", 16),
				Integer.parseUnsignedInt("003B440E", 16),
				Integer.parseUnsignedInt("00DD5815", 16),
				Integer.parseUnsignedInt("00676767", 16),
				Integer.parseUnsignedInt("00EC9CB7", 16),
				Integer.parseUnsignedInt("0037C52A", 16),
				Integer.parseUnsignedInt("00BAC57B", 16),
				Integer.parseUnsignedInt("0089D5B9", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	
	/**
	 * Creates a 16 colour palette based on the commodore 64 colours.
	 * @return A Palette based on commodore 64 colours.
	 */
	private static Palette makePalette_C6416(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16),
				Integer.parseUnsignedInt("00880000", 16),
				Integer.parseUnsignedInt("00AAFFEE", 16),
				Integer.parseUnsignedInt("00CC44CC", 16),
				Integer.parseUnsignedInt("0000CC55", 16),
				Integer.parseUnsignedInt("000000AA", 16),
				Integer.parseUnsignedInt("00EEEE77", 16),
				Integer.parseUnsignedInt("00DD8855", 16),
				Integer.parseUnsignedInt("00664400", 16),
				Integer.parseUnsignedInt("00FF7777", 16),
				Integer.parseUnsignedInt("00333333", 16),
				Integer.parseUnsignedInt("00777777", 16),
				Integer.parseUnsignedInt("00AAFF66", 16),
				Integer.parseUnsignedInt("000088FF", 16),
				Integer.parseUnsignedInt("00BBBBBB", 16)});
	}
	
	
	/**
	 * Creates a 16 colour palette based on the VGA default colours.
	 * @return A Palette based on VGA colours.
	 */
	private static Palette makePalette_VGA16(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("000000AA", 16),
				Integer.parseUnsignedInt("0000AA00", 16),
				Integer.parseUnsignedInt("0000AAAA", 16),
				Integer.parseUnsignedInt("00AA0000", 16),
				Integer.parseUnsignedInt("00AA00AA", 16),
				Integer.parseUnsignedInt("00AA5500", 16),
				Integer.parseUnsignedInt("00AAAAAA", 16),
				Integer.parseUnsignedInt("00555555", 16),
				Integer.parseUnsignedInt("005555FF", 16),
				Integer.parseUnsignedInt("0055FF55", 16),
				Integer.parseUnsignedInt("0055FFFF", 16),
				Integer.parseUnsignedInt("00FF5555", 16),
				Integer.parseUnsignedInt("00FF55FF", 16),
				Integer.parseUnsignedInt("00FFFF55", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a 64 colour palette based on the EGA colours.
	 * @return A Palette based on EGA colours.
	 */
	private static Palette makePalette_EGA64(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("000000AA", 16),
				Integer.parseUnsignedInt("0000AA00", 16),
				Integer.parseUnsignedInt("0000AAAA", 16),
				Integer.parseUnsignedInt("00AA0000", 16),
				Integer.parseUnsignedInt("00AA00AA", 16),
				Integer.parseUnsignedInt("00AAAA00", 16),
				Integer.parseUnsignedInt("00AAAAAA", 16),
				Integer.parseUnsignedInt("00000055", 16),
				Integer.parseUnsignedInt("000000FF", 16),
				Integer.parseUnsignedInt("0000AA55", 16),
				Integer.parseUnsignedInt("0000AAFF", 16),
				Integer.parseUnsignedInt("00AA0055", 16),
				Integer.parseUnsignedInt("00AA00FF", 16),
				Integer.parseUnsignedInt("00AAAA55", 16),
				Integer.parseUnsignedInt("00AAAAFF", 16),
				
				Integer.parseUnsignedInt("00005500", 16),
				Integer.parseUnsignedInt("000055AA", 16),
				Integer.parseUnsignedInt("0000FF00", 16),
				Integer.parseUnsignedInt("0000FFAA", 16),
				Integer.parseUnsignedInt("00AA5500", 16),
				Integer.parseUnsignedInt("00AA55AA", 16),
				Integer.parseUnsignedInt("00AAFF00", 16),
				Integer.parseUnsignedInt("00AAFFAA", 16),
				Integer.parseUnsignedInt("00005555", 16),
				Integer.parseUnsignedInt("000055FF", 16),
				Integer.parseUnsignedInt("0000FF55", 16),
				Integer.parseUnsignedInt("0000FFFF", 16),
				Integer.parseUnsignedInt("00AA5555", 16),
				Integer.parseUnsignedInt("00AA55FF", 16),
				Integer.parseUnsignedInt("00AAFF55", 16),
				Integer.parseUnsignedInt("00AAFFFF", 16),
				
				Integer.parseUnsignedInt("00550000", 16),
				Integer.parseUnsignedInt("005500AA", 16),
				Integer.parseUnsignedInt("0055AA00", 16),
				Integer.parseUnsignedInt("0055AAAA", 16),
				Integer.parseUnsignedInt("00FF0000", 16),
				Integer.parseUnsignedInt("00FF00AA", 16),
				Integer.parseUnsignedInt("00FFAA00", 16),
				Integer.parseUnsignedInt("00FFAAAA", 16),
				Integer.parseUnsignedInt("00550055", 16),
				Integer.parseUnsignedInt("005500FF", 16),
				Integer.parseUnsignedInt("0055AA55", 16),
				Integer.parseUnsignedInt("0055AAFF", 16),
				Integer.parseUnsignedInt("00FF0055", 16),
				Integer.parseUnsignedInt("00FF00FF", 16),
				Integer.parseUnsignedInt("00FFAA55", 16),
				Integer.parseUnsignedInt("00FFAAFF", 16),
				
				Integer.parseUnsignedInt("00555500", 16),
				Integer.parseUnsignedInt("005555AA", 16),
				Integer.parseUnsignedInt("0055FF00", 16),
				Integer.parseUnsignedInt("0055FFAA", 16),
				Integer.parseUnsignedInt("00FF5500", 16),
				Integer.parseUnsignedInt("00FF55AA", 16),
				Integer.parseUnsignedInt("00FFFF00", 16),
				Integer.parseUnsignedInt("00FFFFAA", 16),
				Integer.parseUnsignedInt("00555555", 16),
				Integer.parseUnsignedInt("005555FF", 16),
				Integer.parseUnsignedInt("0055FF55", 16),
				Integer.parseUnsignedInt("0055FFFF", 16),
				Integer.parseUnsignedInt("00FF5555", 16),
				Integer.parseUnsignedInt("00FF55FF", 16),
				Integer.parseUnsignedInt("00FFFF55", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a black and white Palette.
	 * @return A black and white Palette.
	 */
	private static Palette makePalette_BlackAndWhite(){
		return new Palette(new int[]{Integer.parseUnsignedInt("00000000", 16), Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a Palette with 4 greys.
	 * @return A Palette with 4 greys.
	 */
	private static Palette makePalette_Grey4(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16), 
				Integer.parseUnsignedInt("004F4F4F", 16),
				Integer.parseUnsignedInt("00999999", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a Palette with 8 greys.
	 * @return A Palette with 8 greys.
	 */
	private static Palette makePalette_Grey8(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("002A2A2A", 16),
				Integer.parseUnsignedInt("00454545", 16),
				Integer.parseUnsignedInt("00626262", 16),
				Integer.parseUnsignedInt("00838383", 16),
				Integer.parseUnsignedInt("00A6A6A6", 16),
				Integer.parseUnsignedInt("00CFCFCF", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a Palette with 16 greys.
	 * @return A Palette with 16 greys.
	 */
	private static Palette makePalette_Grey16(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("001B1B1B", 16),
				Integer.parseUnsignedInt("00292929", 16),
				Integer.parseUnsignedInt("00353535", 16),
				Integer.parseUnsignedInt("00414141", 16),
				Integer.parseUnsignedInt("004F4F4F", 16),
				Integer.parseUnsignedInt("005C5C5C", 16),
				Integer.parseUnsignedInt("006B6B6B", 16),
				Integer.parseUnsignedInt("00797979", 16),
				Integer.parseUnsignedInt("008A8A8A", 16),
				Integer.parseUnsignedInt("00999999", 16),
				Integer.parseUnsignedInt("00ABABAB", 16),
				Integer.parseUnsignedInt("00BDBDBD", 16),
				Integer.parseUnsignedInt("00D1D1D1", 16),
				Integer.parseUnsignedInt("00E5E5E5", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	/**
	 * Creates a Palette with 32 greys.
	 * @return A Palette with 32 greys.
	 */
	private static Palette makePalette_Grey32(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("00121212", 16),
				Integer.parseUnsignedInt("001B1B1B", 16),
				Integer.parseUnsignedInt("00232323", 16),
				Integer.parseUnsignedInt("00282828", 16),
				Integer.parseUnsignedInt("002E2E2E", 16),
				Integer.parseUnsignedInt("00343434", 16),
				Integer.parseUnsignedInt("003A3A3A", 16),
				Integer.parseUnsignedInt("00404040", 16),
				Integer.parseUnsignedInt("00454545", 16),
				Integer.parseUnsignedInt("004C4C4C", 16),
				Integer.parseUnsignedInt("00525252", 16),
				Integer.parseUnsignedInt("005A5A5A", 16),
				Integer.parseUnsignedInt("00616161", 16),
				Integer.parseUnsignedInt("00686868", 16),
				Integer.parseUnsignedInt("006E6E6E", 16),
				Integer.parseUnsignedInt("00767676", 16),
				Integer.parseUnsignedInt("007C7C7C", 16),
				Integer.parseUnsignedInt("00848484", 16),
				Integer.parseUnsignedInt("008C8C8C", 16),
				Integer.parseUnsignedInt("00949494", 16),
				Integer.parseUnsignedInt("009C9C9C", 16),
				Integer.parseUnsignedInt("00A5A5A5", 16),
				Integer.parseUnsignedInt("00ACACAC", 16),
				Integer.parseUnsignedInt("00B6B6B6", 16),
				Integer.parseUnsignedInt("00C0C0C0", 16),
				Integer.parseUnsignedInt("00C8C8C8", 16),
				Integer.parseUnsignedInt("00D2D2D2", 16),
				Integer.parseUnsignedInt("00DBDBDB", 16),
				Integer.parseUnsignedInt("00E5E5E5", 16),
				Integer.parseUnsignedInt("00F1F1F1", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16),
				
		});
	}
	
	/**
	 * Creates a Palette with 256 greys.
	 * @return A Palette with 256 greys.
	 */
	private static Palette makePalette_Grey256(){
		return new Palette(new int[]{
				Integer.parseUnsignedInt("00000000", 16),
				Integer.parseUnsignedInt("00010101", 16),
				Integer.parseUnsignedInt("00020202", 16),
				Integer.parseUnsignedInt("00030303", 16),
				Integer.parseUnsignedInt("00040404", 16),
				Integer.parseUnsignedInt("00050505", 16),
				Integer.parseUnsignedInt("00060606", 16),
				Integer.parseUnsignedInt("00070707", 16),
				Integer.parseUnsignedInt("00080808", 16),
				Integer.parseUnsignedInt("00090909", 16),
				Integer.parseUnsignedInt("000A0A0A", 16),
				Integer.parseUnsignedInt("000B0B0B", 16),
				Integer.parseUnsignedInt("000C0C0C", 16),
				Integer.parseUnsignedInt("000D0D0D", 16),
				Integer.parseUnsignedInt("000E0E0E", 16),
				Integer.parseUnsignedInt("000F0F0F", 16),
				
				Integer.parseUnsignedInt("00101010", 16),
				Integer.parseUnsignedInt("00111111", 16),
				Integer.parseUnsignedInt("00121212", 16),
				Integer.parseUnsignedInt("00131313", 16),
				Integer.parseUnsignedInt("00141414", 16),
				Integer.parseUnsignedInt("00151515", 16),
				Integer.parseUnsignedInt("00161616", 16),
				Integer.parseUnsignedInt("00171717", 16),
				Integer.parseUnsignedInt("00181818", 16),
				Integer.parseUnsignedInt("00191919", 16),
				Integer.parseUnsignedInt("001A1A1A", 16),
				Integer.parseUnsignedInt("001B1B1B", 16),
				Integer.parseUnsignedInt("001C1C1C", 16),
				Integer.parseUnsignedInt("001D1D1D", 16),
				Integer.parseUnsignedInt("001E1E1E", 16),
				Integer.parseUnsignedInt("001F1F1F", 16),
				
				Integer.parseUnsignedInt("00202020", 16),
				Integer.parseUnsignedInt("00212121", 16),
				Integer.parseUnsignedInt("00222222", 16),
				Integer.parseUnsignedInt("00232323", 16),
				Integer.parseUnsignedInt("00242424", 16),
				Integer.parseUnsignedInt("00252525", 16),
				Integer.parseUnsignedInt("00262626", 16),
				Integer.parseUnsignedInt("00272727", 16),
				Integer.parseUnsignedInt("00282828", 16),
				Integer.parseUnsignedInt("00292929", 16),
				Integer.parseUnsignedInt("002A2A2A", 16),
				Integer.parseUnsignedInt("002B2B2B", 16),
				Integer.parseUnsignedInt("002C2C2C", 16),
				Integer.parseUnsignedInt("002D2D2D", 16),
				Integer.parseUnsignedInt("002E2E2E", 16),
				Integer.parseUnsignedInt("002F2F2F", 16),
				
				Integer.parseUnsignedInt("00303030", 16),
				Integer.parseUnsignedInt("00313131", 16),
				Integer.parseUnsignedInt("00323232", 16),
				Integer.parseUnsignedInt("00333333", 16),
				Integer.parseUnsignedInt("00343434", 16),
				Integer.parseUnsignedInt("00353535", 16),
				Integer.parseUnsignedInt("00363636", 16),
				Integer.parseUnsignedInt("00373737", 16),
				Integer.parseUnsignedInt("00383838", 16),
				Integer.parseUnsignedInt("00393939", 16),
				Integer.parseUnsignedInt("003A3A3A", 16),
				Integer.parseUnsignedInt("003B3B3B", 16),
				Integer.parseUnsignedInt("003C3C3C", 16),
				Integer.parseUnsignedInt("003D3D3D", 16),
				Integer.parseUnsignedInt("003E3E3E", 16),
				Integer.parseUnsignedInt("003F3F3F", 16),
				
				Integer.parseUnsignedInt("00404040", 16),
				Integer.parseUnsignedInt("00414141", 16),
				Integer.parseUnsignedInt("00424242", 16),
				Integer.parseUnsignedInt("00434343", 16),
				Integer.parseUnsignedInt("00444444", 16),
				Integer.parseUnsignedInt("00454545", 16),
				Integer.parseUnsignedInt("00464646", 16),
				Integer.parseUnsignedInt("00474747", 16),
				Integer.parseUnsignedInt("00484848", 16),
				Integer.parseUnsignedInt("00494949", 16),
				Integer.parseUnsignedInt("004A4A4A", 16),
				Integer.parseUnsignedInt("004B4B4B", 16),
				Integer.parseUnsignedInt("004C4C4C", 16),
				Integer.parseUnsignedInt("004D4D4D", 16),
				Integer.parseUnsignedInt("004E4E4E", 16),
				Integer.parseUnsignedInt("004F4F4F", 16),
				
				Integer.parseUnsignedInt("00505050", 16),
				Integer.parseUnsignedInt("00515151", 16),
				Integer.parseUnsignedInt("00525252", 16),
				Integer.parseUnsignedInt("00535353", 16),
				Integer.parseUnsignedInt("00545454", 16),
				Integer.parseUnsignedInt("00555555", 16),
				Integer.parseUnsignedInt("00565656", 16),
				Integer.parseUnsignedInt("00575757", 16),
				Integer.parseUnsignedInt("00585858", 16),
				Integer.parseUnsignedInt("00595959", 16),
				Integer.parseUnsignedInt("005A5A5A", 16),
				Integer.parseUnsignedInt("005B5B5B", 16),
				Integer.parseUnsignedInt("005C5C5C", 16),
				Integer.parseUnsignedInt("005D5D5D", 16),
				Integer.parseUnsignedInt("005E5E5E", 16),
				Integer.parseUnsignedInt("005F5F5F", 16),
				
				Integer.parseUnsignedInt("00606060", 16),
				Integer.parseUnsignedInt("00616161", 16),
				Integer.parseUnsignedInt("00626262", 16),
				Integer.parseUnsignedInt("00636363", 16),
				Integer.parseUnsignedInt("00646464", 16),
				Integer.parseUnsignedInt("00656565", 16),
				Integer.parseUnsignedInt("00666666", 16),
				Integer.parseUnsignedInt("00676767", 16),
				Integer.parseUnsignedInt("00686868", 16),
				Integer.parseUnsignedInt("00696969", 16),
				Integer.parseUnsignedInt("006A6A6A", 16),
				Integer.parseUnsignedInt("006B6B6B", 16),
				Integer.parseUnsignedInt("006C6C6C", 16),
				Integer.parseUnsignedInt("006D6D6D", 16),
				Integer.parseUnsignedInt("006E6E6E", 16),
				Integer.parseUnsignedInt("006F6F6F", 16),
				
				Integer.parseUnsignedInt("00707070", 16),
				Integer.parseUnsignedInt("00717171", 16),
				Integer.parseUnsignedInt("00727272", 16),
				Integer.parseUnsignedInt("00737373", 16),
				Integer.parseUnsignedInt("00747474", 16),
				Integer.parseUnsignedInt("00757575", 16),
				Integer.parseUnsignedInt("00767676", 16),
				Integer.parseUnsignedInt("00777777", 16),
				Integer.parseUnsignedInt("00787878", 16),
				Integer.parseUnsignedInt("00797979", 16),
				Integer.parseUnsignedInt("007A7A7A", 16),
				Integer.parseUnsignedInt("007B7B7B", 16),
				Integer.parseUnsignedInt("007C7C7C", 16),
				Integer.parseUnsignedInt("007D7D7D", 16),
				Integer.parseUnsignedInt("007E7E7E", 16),
				Integer.parseUnsignedInt("007F7F7F", 16),
				
				Integer.parseUnsignedInt("00808080", 16),
				Integer.parseUnsignedInt("00818181", 16),
				Integer.parseUnsignedInt("00828282", 16),
				Integer.parseUnsignedInt("00838383", 16),
				Integer.parseUnsignedInt("00848484", 16),
				Integer.parseUnsignedInt("00858585", 16),
				Integer.parseUnsignedInt("00868686", 16),
				Integer.parseUnsignedInt("00878787", 16),
				Integer.parseUnsignedInt("00888888", 16),
				Integer.parseUnsignedInt("00898989", 16),
				Integer.parseUnsignedInt("008A8A8A", 16),
				Integer.parseUnsignedInt("008B8B8B", 16),
				Integer.parseUnsignedInt("008C8C8C", 16),
				Integer.parseUnsignedInt("008D8D8D", 16),
				Integer.parseUnsignedInt("008E8E8E", 16),
				Integer.parseUnsignedInt("008F8F8F", 16),
				
				Integer.parseUnsignedInt("00909090", 16),
				Integer.parseUnsignedInt("00919191", 16),
				Integer.parseUnsignedInt("00929292", 16),
				Integer.parseUnsignedInt("00939393", 16),
				Integer.parseUnsignedInt("00949494", 16),
				Integer.parseUnsignedInt("00959595", 16),
				Integer.parseUnsignedInt("00969696", 16),
				Integer.parseUnsignedInt("00979797", 16),
				Integer.parseUnsignedInt("00989898", 16),
				Integer.parseUnsignedInt("00999999", 16),
				Integer.parseUnsignedInt("009A9A9A", 16),
				Integer.parseUnsignedInt("009B9B9B", 16),
				Integer.parseUnsignedInt("009C9C9C", 16),
				Integer.parseUnsignedInt("009D9D9D", 16),
				Integer.parseUnsignedInt("009E9E9E", 16),
				Integer.parseUnsignedInt("009F9F9F", 16),
				
				Integer.parseUnsignedInt("00A0A0A0", 16),
				Integer.parseUnsignedInt("00A1A1A1", 16),
				Integer.parseUnsignedInt("00A2A2A2", 16),
				Integer.parseUnsignedInt("00A3A3A3", 16),
				Integer.parseUnsignedInt("00A4A4A4", 16),
				Integer.parseUnsignedInt("00A5A5A5", 16),
				Integer.parseUnsignedInt("00A6A6A6", 16),
				Integer.parseUnsignedInt("00A7A7A7", 16),
				Integer.parseUnsignedInt("00A8A8A8", 16),
				Integer.parseUnsignedInt("00A9A9A9", 16),
				Integer.parseUnsignedInt("00AAAAAA", 16),
				Integer.parseUnsignedInt("00ABABAB", 16),
				Integer.parseUnsignedInt("00ACACAC", 16),
				Integer.parseUnsignedInt("00ADADAD", 16),
				Integer.parseUnsignedInt("00AEAEAE", 16),
				Integer.parseUnsignedInt("00AFAFAF", 16),
				
				Integer.parseUnsignedInt("00B0B0B0", 16),
				Integer.parseUnsignedInt("00B1B1B1", 16),
				Integer.parseUnsignedInt("00B2B2B2", 16),
				Integer.parseUnsignedInt("00B3B3B3", 16),
				Integer.parseUnsignedInt("00B4B4B4", 16),
				Integer.parseUnsignedInt("00B5B5B5", 16),
				Integer.parseUnsignedInt("00B6B6B6", 16),
				Integer.parseUnsignedInt("00B7B7B7", 16),
				Integer.parseUnsignedInt("00B8B8B8", 16),
				Integer.parseUnsignedInt("00B9B9B9", 16),
				Integer.parseUnsignedInt("00BABABA", 16),
				Integer.parseUnsignedInt("00BBBBBB", 16),
				Integer.parseUnsignedInt("00BCBCBC", 16),
				Integer.parseUnsignedInt("00BDBDBD", 16),
				Integer.parseUnsignedInt("00BEBEBE", 16),
				Integer.parseUnsignedInt("00BFBFBF", 16),
				
				Integer.parseUnsignedInt("00C0C0C0", 16),
				Integer.parseUnsignedInt("00C1C1C1", 16),
				Integer.parseUnsignedInt("00C2C2C2", 16),
				Integer.parseUnsignedInt("00C3C3C3", 16),
				Integer.parseUnsignedInt("00C4C4C4", 16),
				Integer.parseUnsignedInt("00C5C5C5", 16),
				Integer.parseUnsignedInt("00C6C6C6", 16),
				Integer.parseUnsignedInt("00C7C7C7", 16),
				Integer.parseUnsignedInt("00C8C8C8", 16),
				Integer.parseUnsignedInt("00C9C9C9", 16),
				Integer.parseUnsignedInt("00CACACA", 16),
				Integer.parseUnsignedInt("00CBCBCB", 16),
				Integer.parseUnsignedInt("00CCCCCC", 16),
				Integer.parseUnsignedInt("00CDCDCD", 16),
				Integer.parseUnsignedInt("00CECECE", 16),
				Integer.parseUnsignedInt("00CFCFCF", 16),
				
				Integer.parseUnsignedInt("00D0D0D0", 16),
				Integer.parseUnsignedInt("00D1D1D1", 16),
				Integer.parseUnsignedInt("00D2D2D2", 16),
				Integer.parseUnsignedInt("00D3D3D3", 16),
				Integer.parseUnsignedInt("00D4D4D4", 16),
				Integer.parseUnsignedInt("00D5D5D5", 16),
				Integer.parseUnsignedInt("00D6D6D6", 16),
				Integer.parseUnsignedInt("00D7D7D7", 16),
				Integer.parseUnsignedInt("00D8D8D8", 16),
				Integer.parseUnsignedInt("00D9D9D9", 16),
				Integer.parseUnsignedInt("00DADADA", 16),
				Integer.parseUnsignedInt("00DBDBDB", 16),
				Integer.parseUnsignedInt("00DCDCDC", 16),
				Integer.parseUnsignedInt("00DDDDDD", 16),
				Integer.parseUnsignedInt("00DEDEDE", 16),
				Integer.parseUnsignedInt("00DFDFDF", 16),
				
				Integer.parseUnsignedInt("00E0E0E0", 16),
				Integer.parseUnsignedInt("00E1E1E1", 16),
				Integer.parseUnsignedInt("00E2E2E2", 16),
				Integer.parseUnsignedInt("00E3E3E3", 16),
				Integer.parseUnsignedInt("00E4E4E4", 16),
				Integer.parseUnsignedInt("00E5E5E5", 16),
				Integer.parseUnsignedInt("00E6E6E6", 16),
				Integer.parseUnsignedInt("00E7E7E7", 16),
				Integer.parseUnsignedInt("00E8E8E8", 16),
				Integer.parseUnsignedInt("00E9E9E9", 16),
				Integer.parseUnsignedInt("00EAEAEA", 16),
				Integer.parseUnsignedInt("00EBEBEB", 16),
				Integer.parseUnsignedInt("00ECECEC", 16),
				Integer.parseUnsignedInt("00EDEDED", 16),
				Integer.parseUnsignedInt("00EEEEEE", 16),
				Integer.parseUnsignedInt("00EFEFEF", 16),
				
				Integer.parseUnsignedInt("00F0F0F0", 16),
				Integer.parseUnsignedInt("00F1F1F1", 16),
				Integer.parseUnsignedInt("00F2F2F2", 16),
				Integer.parseUnsignedInt("00F3F3F3", 16),
				Integer.parseUnsignedInt("00F4F4F4", 16),
				Integer.parseUnsignedInt("00F5F5F5", 16),
				Integer.parseUnsignedInt("00F6F6F6", 16),
				Integer.parseUnsignedInt("00F7F7F7", 16),
				Integer.parseUnsignedInt("00F8F8F8", 16),
				Integer.parseUnsignedInt("00F9F9F9", 16),
				Integer.parseUnsignedInt("00FAFAFA", 16),
				Integer.parseUnsignedInt("00FBFBFB", 16),
				Integer.parseUnsignedInt("00FCFCFC", 16),
				Integer.parseUnsignedInt("00FDFDFD", 16),
				Integer.parseUnsignedInt("00FEFEFE", 16),
				Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
}
