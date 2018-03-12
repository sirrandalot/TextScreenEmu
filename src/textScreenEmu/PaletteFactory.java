package textScreenEmu;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

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
		
		try{
			
			if(colours.length < 2)
				throw new Exception("Palette must contain at least 2 colours.");
			
			return new Palette(colours);
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * Creates a pre-defined Palette.
	 * @param p The PalettePredef enum value.
	 * @return A Palette based on the value given.
	 */
	public static Palette createPalette(PalettePredef p){
		
		switch(p){
		case BLACK_AND_WHITE:
			return getPaletteFromFile("pal_BLACK_AND_WHITE.png", 2);
		case GREY_4:
			return getPaletteFromFile("pal_GREY_4.png", 4);
		case GREY_8:
			return getPaletteFromFile("pal_GREY_8.png", 8);
		case GREY_16:
			return getPaletteFromFile("pal_GREY_16.png", 16);
		case GREY_32:
			return getPaletteFromFile("pal_GREY_32.png", 32);
		case GREY_256:
			return getPaletteFromFile("pal_GREY_256.png", 256);
		case VGA_16:
			return getPaletteFromFile("pal_VGA_16.png", 16);
		case EGA_64:
			return getPaletteFromFile("pal_EGA_64.png", 64);
		case C64_16:
			return getPaletteFromFile("pal_C64_16.png", 16);
		case APPLEII_16:
			return getPaletteFromFile("pal_APPLEII_16.png", 16);
		case SPECTRUM_16:
			return getPaletteFromFile("pal_SPECTRUM_16.png", 16);
		case CGA_16:
			return getPaletteFromFile("pal_CGA_16.png", 16);
		case MSX_16:
			return getPaletteFromFile("pal_MSX_16.png", 16);
		case C16_128:
			return getPaletteFromFile("pal_C16_128.png", 128);
		case GAMEBOY_4:
			return getPaletteFromFile("pal_GAMEBOY_4.png", 4);
		case NES_64:
			return getPaletteFromFile("pal_NES_64.png", 64);
		case PHOSPHOR_8:
			return getPaletteFromFile("pal_PHOSPHOR_8.png", 8);
		default:
			System.out.println("Enum value not recognized, returning black and white palette...");
			return getPaletteFromFile("pal_BLACK_AND_WHITE.png", 2);
			
		}
	}
	


	/**
	 * Creates a Palette using an image saved inside the image package.
	 * @param name The name of the image file.
	 * @param numColours The number of colours to use.
	 * @return A Palette based off of an image file in the image package.
	 */
	private static Palette getPaletteFromFile(String name, int numColours){
		BufferedImage img = null;
		
		try{
			
			img = ImageIO.read(PaletteFactory.class.getResource("/textScreenEmu/images/palettes/" + name));
			
			return getPaletteFromImage(img, numColours);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//If all fails return black and white
		return new Palette(new int[]{Integer.parseUnsignedInt("00000000", 16), Integer.parseUnsignedInt("00FFFFFF", 16)});
	}
	
	
	/**
	 * Creates a palette from a BufferedImage, each pixel represents one colour to use,
	 * limited (if applicable) by the number of colours wanted.
	 * @param img The BufferedImage to use.
	 * @param numColours The number of colours to use.
	 * @return A Palette based off of a BufferedImage.
	 */
	public static Palette getPaletteFromImage(BufferedImage img, int numColours){
		
		try{
			//Check if the parameters are appropriate
			if(numColours < 2 || numColours > 256 || numColours > img.getWidth()*img.getHeight())
				throw new Exception("Number of colours " + numColours + " out of range, must be between 2 and " + Integer.min(256, img.getWidth()*img.getHeight()) + " inclusively.");
			
			//Create an array
			int[] vals = new int[numColours];
			
			int x = 0;
			int y = 0;
			
			//Get the colours from each pixel
			for(int c = 0; c < numColours; c++){
				
				vals[c] = img.getRGB(x, y);
				
				x++;
				
				if(x >= img.getWidth()){
					x = 0;
					y++;
				}
			}
			
			return new Palette(vals);
			
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		//If all fails return black and white
		return new Palette(new int[]{Integer.parseUnsignedInt("00000000", 16), Integer.parseUnsignedInt("00FFFFFF", 16)});
		
	}
	
}
