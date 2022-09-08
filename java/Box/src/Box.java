public class Box {
	
	//Instance variables that define what a Box has
	private int length,width,height;
	
	/*
	 * Default Box Constructor for a box. The default height,
	 * width and length of the box will be set equal to 1
	 * 
	 */
	public Box() {
		length=1;
		width=1;
		height=1;
	}//Box Constructor 
	
	/*
	 * A Box Constructor that takes in 3 parameters 
	 * 
	 * @param length the length of the box
	 * @param width the width of the box
	 * @param height the height of the box
	 * @throws IllegalBoxException if any of the arguments
	 * are less than 1
	 */
	public Box(int length,int width,int height) {
		if(length < 1 || width < 1 || height < 1) {
			throw new IllegalBoxException("Invalid Arguements. Try Again.");
		}
		this.length = length;
		this.width=width;
		this.height=height;
	}//Box Constructor
	
	/*
	 * @return the length passed to the constructor
	 */
	public int getLength() {
		return length;
	}//getLength
	
	/*
	 * @return the width passed to the constructor
	 */
	public int getWidth() {
		return width;
	}//getWidth
	
	/*
	 * @return the height passed to the constructor
	 */
	public int getHeight() {
		return height;
	}//getHeight
	
	/*
	 * @param length sets the length of the box
	 * @throws IllegalBoxException if the length is less than 1
	 */
	public void setLength(int length) {
		if(length < 1) throw new IllegalBoxException("Invalid Arguements. Try Again.");
		this.length = length;
	}//setLength
	
	/*
	 * @param width sets the width of the box
	 * @throws IllegalBoxException if the width is less than 1
	 */
	public void setWidth(int width) {
		if(width < 1) throw new IllegalBoxException("Invalid Arguements. Try Again.");
		this.width = width;
	}//setWidth
	
	/*
	 * @param height sets the height of the box
	 * @throws IllegalBoxException if the height is less than 1
	 */
	public void setHeight(int height) {
		if(height < 1) throw new IllegalBoxException("Invalid Arguements. Try Again.");
		this.height = height;
	}//setHeight
	
	/*
	 * Calculates the volume of the box
	 * 
	 * @return the volume of the box which is the
	 * length multiplied by the width and height
	 */
	public int volume() {
		return length*width*height;
	}//volume
	
	/*
	 * Compares two boxes to see if they are equal to each other. 
	 * 
	 * @return true if the length, width, and height of both boxes
	 * are equal, otherwise false
	 */
	public boolean equals(Box b) {
		return this.length==b.length && this.width==b.width && this.height==b.height;
	}//equals
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Represents a box object as a string
	 */
	public String toString() {
		return "L:" + length + " W:" + width + " H:" + height + " (V:" + volume() + ")";
	}//toString
	
}