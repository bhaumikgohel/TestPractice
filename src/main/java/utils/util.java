package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Base.TestBase;

public class util extends TestBase{

	public static void WaitforElement(WebElement e) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver);
		
		f.withTimeout(Duration.ofSeconds(20));
		f.pollingEvery(Duration.ofSeconds(2));
		f.withMessage("Element not found");
		f.ignoring(Exception.class);
		
		f.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	public static void ScrolluptoElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotname) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    TakesScreenshot ts = (TakesScreenshot)driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    String destination = System.getProperty("user.dir")+"/screenshots/" + screenshotname + dateName 
		            + ".png";
		    File finalDestination = new File(destination);
		    FileUtils.copyFile(source, finalDestination);
		    return destination;
	}
	
}
