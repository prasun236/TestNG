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

public class ValidateTitle extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
				
		LandingPage l = new LandingPage(driver);
		System.out.println(l.getTitle().getText());
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURS");
		
		log.info("Sucessfully validated Text Message");

		
	}

	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver=null;

	}



}
