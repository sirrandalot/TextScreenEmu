package textScreenEmu;

/**
 * Class representing a colour palette, with colours represented as integers following the scheme 0x__RRGGBB.
 * @author sirrandalot
 *
 */
public class Palette {
	
	/**
	 * The colour values in this palette.
	 */
	protected int[] colours;

	
	/**
	 * Constructor for Palette using an array of ints.
	 * @param cols The integer colour values.
	 */
	protected Palette(int[] cols){
		
		try{
			
			if(cols.length > 256)
				throw new Exception("Array length " + cols.length + " out of range, must be between 0 and 256 inclusively.");
			
			colours = cols.clone();
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Gets the number of colours in this palette.
	 * @return The number of colours in this palette.
	 */
	public int getNumColours(){
		return colours.length;
	}
	
	
	/**
	 * Gets the colour at a specified index.
	 * @param index The index.
	 * @return The colour at the specified index.
	 */
	public int getColourAt(int index){
		try{
			
			if(index < 0 || index > colours.length)
				throw new Exception("Index " + index + " out of range, must be between 0 and colours array length.");
			
			return colours[index];
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
			
			return Integer.parseInt("00000000", 16);
		}
		
	}
	
	
	/**
	 * Sets the colour at the specified index.
	 * @param index The index.
	 * @param colour The colour to set.
	 */
	public void setColourAt(int index, int colour){
		try{
			
			if(index < 0 || index > colours.length)
				throw new Exception("Index " + index + " out of range, must be between 0 and colours array length.");
			
			colours[index] = colour;
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Adds a given integer colour onto the end of the palette.
	 * @param colour The colour to add.
	 */
	public void addColour(int colour){
		
		try{
			
			if(colours.length == 256)
				throw new Exception("Colour array full (256 colours), cannot add any more.");
			
			int[] newColours = new int[colours.length + 1];
			
			for(int i = 0; i < colours.length; i++)
				newColours[i] = colours[i];
			
			newColours[newColours.length-1] = colour;
			
			colours = newColours;
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
	}
	
}
