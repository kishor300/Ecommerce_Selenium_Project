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

public class About_us {
	WebDriver driver;
	  @Test
	  public void remove() throws IOException, InterruptedException {
		  
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();
		  
		  FileReader reader=new FileReader("C:\\Users\\kishor\\eclipse-workspace\\Ecommerce\\configs\\Configuration.properties");
			Properties props=new Properties();
			props.load(reader);
		 
		  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(props.getProperty("userName"));
		 
			Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(props.getProperty("password"));
		 
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.linkText("About")).click();
			
			String title=driver.getTitle();
		  	  String ActualTitle="Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
		  	  if(title.equalsIgnoreCase(ActualTitle))
		  	  {
		  		  System.out.println("About us successfully displayed...!");
		  		 
		  	  }
		  	  else
		  	  {
		  		  System.out.println("About us is not displayed...!");
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
