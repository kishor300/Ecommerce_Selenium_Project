package ExcelR.Ecommerce;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_byname {

  WebDriver driver;

  @Test
  public void FilterbyName() throws IOException, InterruptedException {
	  	  
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
	    

	    Select sorting = new Select(driver.findElement(By.xpath(props.getProperty("sorting"))));
		  sorting.selectByValue(props.getProperty("name1"));
		  
	
		  WebElement product1 = driver.findElement(By.xpath(props.getProperty("last_Product")));
		  String actProduct = product1.getText();
		  String expProduct = props.getProperty("exp_Product");
		  Assert.assertTrue(actProduct.equals(expProduct));

	   
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
  
