package ExcelR.Ecommerce;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Continuebutton {
	WebDriver driver;
	  @Test
	  public void remove() throws IOException, InterruptedException {
		  
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
			
			driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
			
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	        
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
	        
	        Thread.sleep(1000);
	        
	        String title=driver.getTitle();
	  	  String ActualTitle="Swag Labs";
	  	  if(title.equalsIgnoreCase(ActualTitle))
	  	  {
	  		  System.out.println("Working Successfully");
	  		 
	  	  }
	  	  else
	  	  {
	  		  System.out.println("Not Working");
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
