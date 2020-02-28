package SeleniumPkg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SeleniumDemo10 {

	public static void main(String[] args) throws InterruptedException, IOException {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.linkText("Linux"));
		js.executeScript("arguments[0].scrollIntoView(),",element);
	}
	
	

}
