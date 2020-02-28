package SeleniumPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDemo4 {

	public static void main(String[] args) throws InterruptedException {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement search =driver.findElement(By.cssSelector("input[value='Search store']"));
		Actions actions=new Actions(driver);
		actions.keyDown(search,Keys.SHIFT).sendKeys("Computer").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("Build your own computer"));
		
		Assert.assertTrue(driver.getTitle().contains("Build your own computer"));
		
		

	}

}
