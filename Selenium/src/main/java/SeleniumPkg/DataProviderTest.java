package SeleniumPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void beforeTest (String browservalue)
	{
		/* String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		driver = new ChromeDriver(); */
		
		if(browservalue.contentEquals("chrome"))
		{
			System.out.println("Inside Chrome Path Set");
			String InPath = "src/test/resources/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", InPath);
			driver = new ChromeDriver();
			
		}
		else if(browservalue.contentEquals("firefox"))
		{
			
			String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", InPath);
			driver = new FirefoxDriver();
		}
		else if(browservalue.contentEquals("ie"))
		{
			
			String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", InPath);
			driver = new InternetExplorerDriver();
		}
		else
		{
		System.out.println("No driver path set");	
		} 
		//System.out.println("after else");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/login");
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	@Test(dataProvider ="dp1",dataProviderClass = MyDP.class)
//	@Test(dataProvider ="dp1", dataProviderClass = DataProviderTest.class)
	// since we have two columns, parameters are s1 and s2 
	public void testDDT(String s1,String s2)
	{
		System.out.println(s1+"\t"+s2);		
	}

	// this method can be defined in another class and can be invoked with dataProvider class
	@DataProvider (name ="dp1")
	public Object[][] createData() 
	{
		Object[][] obj= {{"sujit","panigrahi"},{"Somu","Guna"}};
		return obj;		
	}
	
	@Test (dataProvider = "dp2", dataProviderClass= MyDP.class)
	public void testLoginDemoableShop (String userName,String Password,String userType) throws InterruptedException
	{
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.partialLinkText("Log out")).click();
		//Thread.sleep(2000);
		driver.findElement(By.linkText("Log in")).click();
	}
}
