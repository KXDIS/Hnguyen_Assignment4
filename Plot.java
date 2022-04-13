/**
 * The plot class
 * @author Hendrick Nguyen
 *
 */
public class Plot {
	
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
		
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p a Plot object
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.width; 
	}
	
	/**
	 * Parameterized constructor
	 * @param x horizontal coordinate of upper left corner
	 * @param y vertical coordinate of upper left corner
	 * @param width  horizontal size
	 * @param depth vertical size

	 */
	public Plot (int x, int y, int width, int depth) {
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.depth = depth; 
		
		
		
	}

	
	/**
	 * 
	 * @param plot plot object
	 * @return Returns true if this plot overlaps the parameter, false otherwise

	 */
	public boolean overlaps (Plot plot) {
		
	boolean overlaps = true;
		
	if (this.y + depth <= plot.getY())
			{
			overlaps =  false;
			}
	else if(this.y >= plot.getY()+plot.getDepth())
			{
			overlaps =  false;
			}
	else if (this.x + width <= plot.getX())
			{
			overlaps = false;
			}
	else if (this.x >= plot.getX()+plot.getWidth())
			{
			overlaps = false;
			}

	return overlaps;

	}
	
	/**
	 * 
	 * @param plot plot object
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses (Plot plot ){
		
		
		return (this.x <=plot.x)
				&&(this.y <= plot.y)
				&&(this.x + this.width >= plot.x + plot.width)
				&&(this.y + this.depth>=plot.y + plot.depth);
			
		
	}
	
	
	
	/**
	 * 
	 * @return Return the x value
	 */
	
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x  the x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return  the y value
	 */
	public int getY() {
		return y;
	}
/**
 * 
 * @param y the y coordinate
 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return  the width value to set
	 */
	public int getWidth() {
		return width;
	}
/**
 * 
 * @param width the width value

 */
	public void setWidth(int width) {
		this.width = width;
	}
/**
 * 
 * @return  the depth value
 */
	public int getDepth() {
		return depth;
	}
/**
 * 
 * @param depth the depth value to set
 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 *  String for displaying the plot
	 */
	@Override
	public String toString() {
		return "Upper left: ("+this.getX()+","+this.getY()+"); Width: "+this.getWidth()+" Depth: "+this.getDepth();
		
	}

}
