import java.util.Arrays;
/** 
 * represents the management company array 
 * @author Hendrick Nguyen
 *
 */
public class ManagementCompany {

	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties = new Property[MAX_PROPERTY];
	private String taxID;
	private  int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;



	/**
	 * Constructor no arg constructor that creates a ManagementCompany object using empty strings and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
properties array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	/**
	 *  Constructor Creates a ManagementCompany object using the passed information.
plot is set to a Plot with x, y set to 0 , width and depth set to 10
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * @param name management company name
	 * @param taxID the tax ID
	 * @param mgmFeePer the management fee per property
	 * @param x x coord beginning
	 * @param y y coord beggining
	 * @param width the width of the property
	 * @param depth the width of the property
	 */
	public ManagementCompany(String name,String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		this.plot = new Plot(x,y,width,depth);
		this.properties =new Property[MAX_PROPERTY];
	}
/**
 *   Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
 * @param otherCompany another management company
 */
	public ManagementCompany (ManagementCompany otherCompany) {

		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;

	}




	/**
	 *  Creates a property object by copying from another property and adds it to the "properties" array.
	 * @param property a property object
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */

	public  int addProperty(Property property){

		if (property == null) 
		{
			return -2;
		}

		if (!(this.plot.encompasses(property.getPlot()))) 
		{												
			return -3;
		}

		for (int i = 0; i < MAX_PROPERTY; i++) 
		{   	
			if (properties[i] != null) {

				if (property.getPlot().overlaps(properties[i].getPlot())) {

					return -4;
				}  
			} 
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {
        	
            if (properties[i] == null) {
            	
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
		

	}

	/**
	 *  Creates a property object with a default plot and adds it to the "properties" array.
	 * @param name property name
	 * @param city location of the property
	 * @param rent monthly rent
	 * @param owner  owner of the property
	 * @param x x location of upper left corner of property's plot
	 * @param y y location of upper left corner of property's plot
	 * @param width width of the property's plot
	 * @param depth depth of the property's plot
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */

	public int addProperty (String name,String city,double rent,String owner, int x, int y, int width,int depth) {

		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));//creating a new object for 

	}

	/**
	 *  Creates a property object and adds it to the "properties" array.
	 * @param name property name
	 * @param city location of the property
	 * @param rent monthly rent
	 * @param owner  owner of the property
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner) {		

		return addProperty(new Property(name,city,rent,owner));
	}

/**
 * This method finds a property within the properties array that 
 * has the maximum rent amount and returns the rent amount.
 * @return double, the maximum rent amount
 */
	public double maxRentProp(){

		return properties[maxRentPropertyIndex()].getRentAmount();

	}

	/**
	 * 
	 * @return int , the index of the property with the maximum rent amount
	 */
	private int maxRentPropertyIndex (){	

		int maxIndex = 0;
		double maxRent = 0;

		for (int i = 0; i < properties.length; i++) {
		if(properties[i] != null) {
			
		
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				maxIndex = i;
			}
		}
		}
		return maxIndex;
	}







/**
 * This method accesses each "Property" object within the array "properties" 
 * and sums up the property rent and returns the total amount.
 * @return the info for rent
 */
	public double totalRent() {
		double rent = 0.0;


		for(int i = 0; i< properties.length; i++) {
			
			if (properties[i] != null) 
			{

				rent += properties[i].getRentAmount();
			}

		}


		return rent;
	}








/**
 * This method finds the index of the property with the maximum rent amount.
 * @param i The index of the property within the array "properties"
 * @return information of the property at index i
 */
	private String displayPropertyAtIndex(int i) {

		return properties[i].toString(); 

	}


	/**
	 * Displays the information of all the properties in the "properties" array.
	 */
	@Override
public String toString() {
	return "ManagementCompany [MAX_PROPERTY=" + MAX_PROPERTY + ", mgmFeePer=" + mgmFeePer + ", name=" + name
			+ ", properties=" + Arrays.toString(properties) + ", taxID=" + taxID + ", MGMT_WIDTH=" + MGMT_WIDTH
			+ ", MGMT_DEPTH=" + MGMT_DEPTH + ", plot=" + plot + "]";
}
	/**
	 * Getter for name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
/**
 *  getter for plot
 * @return the plot
 */
	public Plot getPlot() {
		return plot;
	}
/**
 *  Return the MAX_PROPERTY constant that represents the size of the "properties" array.
 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}







}









