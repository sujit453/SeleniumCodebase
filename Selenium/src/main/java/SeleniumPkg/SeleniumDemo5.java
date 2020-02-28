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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SeleniumDemo5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com/");
		driver.findElement(By.name("q")).sendKeys("Accenture India");
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File sr= ts.getScreenshotAs(OutputType.FILE);
		
		//Files.copy(sr, new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Desktop\\Screenshot\\google.png"));
		Files.copy(sr, new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Desktop\\Screenshot\\Screenshot_"+timestamp()+".png"));
		
		System.out.println("Screenshot taken");
		
		driver.get("http://demowebshop.tricentis.com/");
     TakesScreenshot ts1=(TakesScreenshot)driver;
		
		File sr1= ts1.getScreenshotAs(OutputType.FILE);
		Files.copy(sr1, new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Desktop\\Screenshot\\demowebshop"
				+ ".png"));
		
		driver.quit();
		

	}
	
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
	}

}
