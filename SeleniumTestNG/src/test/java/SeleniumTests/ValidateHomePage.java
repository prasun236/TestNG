package SeleniumTests;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateHomePage extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
				
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		//to access objects/methods from another class
		//one is inheritance  (using extends)
		//2nd is creating objects to that class and invoke methods of it
		
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		
		log.info("Entered Email and password success -");
		
		driver.close();
		driver=null;
		log.info("Closing Browser");

	
		
	}
		
	//Parameterization - exec
	@DataProvider
	public Object[][] getData() {
		
		//Row stands for how many different types of tests should run
		//columns stands for how many values per each test
		Object[][] data = new Object[2][2];
		
		data[0][0] = "firstuser@123.com";
		data[0][1] = "asdsad";
		
		data[1][0] = "Seconduser@123.com";
		data[1][1] = "123456";
		
		return data;
	}
	
	
	@AfterTest
	public void teardown() {
		

	}


}
