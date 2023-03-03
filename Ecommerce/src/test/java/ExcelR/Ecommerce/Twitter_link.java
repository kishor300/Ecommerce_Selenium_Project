package ExcelR.Ecommerce;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Twitter_link {

  WebDriver driver;

  @Test
  public void twitterPage() throws IOException, InterruptedException {
	  	  
		  FileReader reader=new FileReader("C:\\Users\\kishor\\eclipse-workspace\\Ecommerce\\configs\\Configuration.properties");

	 Properties props=new Properties();
	 props.load(reader);
	 
	     
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	
	String loginTitle = props.getProperty("title");
	String actualLoginTitle = driver.getTitle();
	Assert.assertEquals(loginTitle, actualLoginTitle);
	
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(props.getProperty("username"));
		 
			Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(props.getProperty("password"));
		 
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='login-button']")).click();

	    Thread.sleep(2000);
	    
	    WebElement twitter = driver.findElement(By.xpath(props.getProperty("twitter")));
		  twitter.click();
		  Thread.sleep(3000);
	 
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb.get(1));
		  
		  
		  String twitterTitle = props.getProperty("twitterTitle");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(twitterTitle, actualTitle);
		  

	   
  }

@BeforeMethod
	public void launchBrowser() {
		  
	WebDriver driver = new ChromeDriver();
		  
	}

	@AfterMethod
	public void closeBrowser() {
		  
	driver.close();
	}


}
  
  