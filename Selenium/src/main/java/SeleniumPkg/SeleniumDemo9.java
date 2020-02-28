package SeleniumPkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class SeleniumDemo9 {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		String command="notepad.exe";
		Runtime run=Runtime.getRuntime();
		run.exec(command);
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_H);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_E);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_L);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_O);
		Thread.sleep(600);
		
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(600);
		
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_O);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_M);
		Thread.sleep(600);
		robot.keyPress(KeyEvent.VK_U);
		Thread.sleep(600);
		
		
		
		
	}
	
	

}
