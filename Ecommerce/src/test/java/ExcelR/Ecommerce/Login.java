package ExcelR.Ecommerce;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	@Test
	  public void login() throws IOException,FileNotFoundException, InterruptedException {
				  
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();
		  
		  FileReader reader=new FileReader("C:\\Users\\kishor\\eclipse-workspace\\Ecommerce\\configs\\Configuration.properties");
			Properties props=new Properties();
			props.load(reader);
		 
		  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(props.getProperty("username"));
		 
			Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(props.getProperty("password"));
		 
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
		  

			  //Verify that the login page is visible
			  String expectedTitle =props.getProperty("title");
			  String actualResult = driver.getTitle();
			 
			  Assert.assertEquals(expectedTitle, actualResult);
			  
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
