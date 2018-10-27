
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test6 {
	 
	public static  WebDriver driver;
	
	
	@BeforeMethod
	public static void first()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\system\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		
	}
	
	@Test
	public static void screenshot() throws IOException
	{
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\system\\Downloads\\chromedriver_win32");
		FileUtils.copyFile(src, dest);
	}
	
	@AfterMethod
	public static void teardown()
	{
		driver.quit();
	}
	
}
