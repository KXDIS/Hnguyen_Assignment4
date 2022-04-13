

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 
	
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		//student add three properties, with plots, to mgmt co
		 p1 = new Property ("E.Jefferson", "rocville", 2000, "Marc Irby",2,1,2,2);
		 p2 = new Property ("Microcenter", "Parkville", 2500, "Tammy Taylor",2,1,2,2);
		 p3 = new Property ("Deez nutz village", "Ya mama's house", 3000, "Hendeez tendeez",6,1,2,2);

		m = new ManagementCompany("Da homie", "1234",4);
				
		
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  

		m=null;
		
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("Dumb street", "dumb city", 3000, "deez");
		p5 = new Property ("deez","nutz",3500, "fiej",5,5,8,7);
		p6 = new Property ("ya", "mama",3600, "fiel", 7,7,9,7);
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
				assertEquals(m.addProperty(p4), 4, 0);	
				assertEquals(m.addProperty(p5), 4, 5);
				assertEquals(m.addProperty(p6) -1, 0);
}
 
	@Test
	public void testMaxRentProp() {
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),3600.0,4);
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(), 17600, 0);
		//student should test if totalRent returns the total rent of properties
	}

 }