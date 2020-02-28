package SeleniumPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class SeleniumDemo11 {

	public static void main(String[] args) throws InterruptedException, IOException {
		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		
		File src=new File("C:\\Users\\Training1.WIN-NFDCINOH1RK\\Desktop\\Screenshot\\login.xlsx");
		FileInputStream fls=new FileInputStream(src);
		System.out.println(fls);
		XSSFWorkbook wb=new XSSFWorkbook(fls);
		XSSFSheet sheet=wb.getSheetAt(0);
		 int rowCount=sheet.getLastRowNum();
		 System.out.println("row count"+rowCount);
		 for(int i=1;i<=rowCount;i++) {
			 
			 String user = sheet.getRow(i).getCell(0).getStringCellValue();
			 System.out.println("user :"+user);
			 
			 String passwd= sheet.getRow(i).getCell(1).getStringCellValue();
			 System.out.println("passwd :"+passwd);
			 
			 driver.findElement(By.linkText("Log in")).click();
			 driver.findElement(By.id("Email")).sendKeys(user);
			 driver.findElement(By.id("Password")).sendKeys(passwd);
			 
			 driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
			 driver.findElement(By.linkText("Log out")).click();
		 }
		
		driver.close();
		fls.close();
		
	}
	
	

}
