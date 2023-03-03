package ExcelR.Ecommerce;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Back2product {
	
	WebDriver driver;
  @Test
  public void login() throws IOException,FileNotFoundException, InterruptedException {
	  
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  
	  FileReader reader=new FileReader("C:\\Users\\kishor\\eclipse-workspace\\Ecommerce\\configs\\Configuration.properties");
		Properties props=new Properties();
		props.load(reader);
	 
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(props.getProperty("username"));
	 
		Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(props.getProperty("password"));
	 
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		String title=driver.getTitle();
	  	  String ActualTitle="Swag Labs";
	  	  if(title.equalsIgnoreCase(ActualTitle))
	  	  {
	  		  System.out.println("Successfully back to product page");
	  		 
	  	  }
	  	  else
	  	  {
	  		  System.out.println("Can not back to product page");
	  	  }
	        
		
		
  }
  @BeforeMethod
  public void launchBrowser() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  
  }

  @AfterMethod
  public void closeBrowser() {
	  
	  driver.close();
  }

}
