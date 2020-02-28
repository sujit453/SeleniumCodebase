package SeleniumPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDemo {
	
	public static void main (String[] args) {
		
		String InPath="C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.id("Email")).sendKeys("sujit453@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("sujit4tcs");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		
		
	}

}
