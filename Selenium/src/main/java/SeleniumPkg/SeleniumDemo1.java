package SeleniumPkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo1 {
	
	public static void main (String[] args) {
		
		String InPath="C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver=new ChromeDriver();
		driver.get("http://172.31.36.202:443/TestMeApp/fetchcat.htm");
		//driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		WebElement Uname=driver.findElement(By.name("userName"));
		Uname.sendKeys("Lalitha");
		
		Select select=new Select (driver.findElement(By.className("country")));
		select.selectByVisibleText("INDIA");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Welcome"));
		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		for(WebElement link : list) {
			System.out.println(link.getText()+""+link.getAttribute(""));
		}
		
	}

}
