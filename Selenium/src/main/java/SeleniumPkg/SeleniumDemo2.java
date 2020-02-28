package SeleniumPkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo2 {

	public static void main(String[] args) {

		String InPath = "C:\\Users\\Public\\Documents\\Selenium\\BrowserDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", InPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("No. of Links" + list.size());
		for (WebElement link : list) {
			System.out.println(link.getText() + ":-" + link.getAttribute("href"));
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText() + ":-" + list.get(i).isDisplayed());
		}

	}

}
