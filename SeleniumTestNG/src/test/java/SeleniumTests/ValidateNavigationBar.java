package SeleniumTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void basePageNavigation() throws IOException {
						
		LandingPage l = new LandingPage(driver);
		System.out.println(l.getTitle().getText());
				
		Assert.assertTrue(l.getNavBar().isDisplayed());
		
		log.info("Navigation Bar displayed successfully");
			
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver=null;
	}



}
