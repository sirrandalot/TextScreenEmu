package textScreenEmu;

public class Palette {
	
	protected int[] colours;

	protected Palette(int[] cols){
		
		try{
			
			if(cols.length > 256)
				throw new Exception("Array length " + cols.length + " out of range, must be between 0 and 256 inclusively.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		colours = cols.clone();
	}
	
	
	public int getNumColours(){
		return colours.length;
	}
	
	public void addColour(int colour){
		
		try{
			
			if(colours.length == 256)
				throw new Exception("Colour array full (256 colours), cannot add any more.");
			
		}catch(Exception e){
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		
		int[] newColours = new int[colours.length + 1];
		
		for(int i = 0; i < colours.length; i++)
			newColours[i] = colours[i];
		
		newColours[newColours.length-1] = colour;
		
		colours = newColours;
	}
	
}
