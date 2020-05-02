package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {
	
	
	Properties prop = new Properties();
	public static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public WebDriver initializeDriver() throws Exception
	{
		FileInputStream fis = new FileInputStream(projectPath+"src\\main\\java\\utils\\data.properties");
		
		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			//co.addArguments("-headless");
			co.setHeadless(false);
			driver = new ChromeDriver(co);
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", projectPath+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Please specify a valid browser");
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://ui.cogmento.com");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

}
