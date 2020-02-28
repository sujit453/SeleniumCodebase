package SeleniumPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumDemo3 {

	public static void main(String[] args) {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]"))).perform();
		actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Camera, photo')]"))).click().build().perform();

	}

}
