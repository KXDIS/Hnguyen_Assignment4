/**
 * The class for the properties inputed
 * @author Hendrick
 *
 */
public class Property {

	
	//Instance variables for the class
	
	private String propertyName = "";
	private String city = "";
	private String owner = "";	
	private double rentAmount;
	private Plot plot;
	
	
	/**
	 * 
	 * @return the name of the property
	 */
public String getPropertyName() {
		return propertyName;
	}

/**
 * 
 * @param propertyName the name of the property
 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
/**
 * 
 * @return the plot
 */
	public Plot getPlot() {
		return plot;
	}
/**
 * 
 * @param plot the plot paramerter
 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
/**
 * 
 * @return the city
 */
	public String getCity() {
		return city;
	}
/**
 * 
 * @param city the city
 */
	public void setCity(String city) {
		this.city = city;
	}
/**
 * 
 * @return the owner of the plot
 */
	public String getOwner() {
		return owner;
	}
/**
 * 
 * @param owner the owner of the plot
 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
/**
 * 
 * @return the current Rent amount
 */
	public double getRentAmount() {
		return rentAmount;
	}
/**
 * 
 * @param rentAmount the rent amount of the plot
 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}




/**
 * Constructor 
 */

public Property() {
	city = "";
	owner = "";
	propertyName = "";
	rentAmount = 0;
	plot = new Plot(0,0,1,1);
	
}
/** 
 * Copy Constructor for creating a new object p
 * @param p new property object
 */


public Property (Property p) {
	this.city = p.city;
	this.owner = p.owner;
	this.propertyName = p.propertyName;
	this.rentAmount = p.rentAmount;
	this.plot = new Plot();

	
}

/**
 * Parameterized Constructor 
 * @param propertyName defaulted property name
 * @param city defaulted city name
 * @param rentAmount defaulted rent amount
 * @param owner defaulted owner
 */
public Property (String propertyName, String city, double rentAmount, String owner) {
	this.city = city;
	this.propertyName = propertyName;
	this.rentAmount = rentAmount;
	this.owner = owner;
	this.plot = new Plot(0,0,1,1);
}

/**
 *  Parameterized constructor for measurements of the plot
 * @param propertyName the property name
 * @param city the city
 * @param rentAmount the rent amoutn
 * @param owner the owner
 * @param x		x coordinate for width
 * @param y		y coordinate for length
 * @param width	width of the plot
 * @param depth	depth of the plot
 */
public Property (String propertyName, String city, double rentAmount, String owner,
				int x , int y, int width, int depth) {
	this.city = city;
	this.propertyName = propertyName;
	this.owner = owner;
	this.rentAmount = rentAmount;
	this.plot = new Plot(x,y,width,depth);
	
	
}

/**
 * The tostring to display the instances the plot is
 */
public String toString() {
	return "Property Name: " + this.propertyName + 
			"\nLocated in: " + this.city +
			"\nBeloning to: " + this.owner +
			"\nRent Amount: " + this.rentAmount + "";
	
}

}
