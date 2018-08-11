package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
				
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
		
		/*Setting the Browser and Driver Paths*/
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./Resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.chrome.driver", "./Resources/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		

	}
	
	public void getScreenshots(String result ) throws IOException {
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots//"+result+"screenshot.png"));
		
	
		
	}
}
