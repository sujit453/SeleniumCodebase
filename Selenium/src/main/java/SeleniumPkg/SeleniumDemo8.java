package SeleniumPkg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class SeleniumDemo8 {

	public static void main(String[] args) throws InterruptedException, IOException {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement from=driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		
		WebElement to=driver.findElement(By.xpath("//ol[@id='bank']//li"));
		
        Actions act=new Actions(driver);
        act.dragAndDrop(from, to).build().perform();
	}
	
	

}
