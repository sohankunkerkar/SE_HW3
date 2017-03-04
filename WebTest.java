package selenium.tests;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebTest
{
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}

	
	/*@Test
	public void googleExists() throws Exception
	{
		driver.get("http://www.google.com");
        assertEquals("Google", driver.getTitle());		
	}*/
	
	/* Question 1*/
	@Test
	public void CheckCount() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]")));
		WebElement check = driver.findElement(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]")));
		assertEquals("Matched","55", check.getText());
	}	
	
	/* Question 2*/
	@Test
	public void Closed() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		
		// http://geekswithblogs.net/Aligned/archive/2014/10/16/selenium-and-timing-issues.aspx
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		List<WebElement> spans = driver.findElements(By.xpath("//a[@class='status']/span[.='CLOSED']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='CLOSED']")));
		assertNotNull(spans);
		assertEquals(5, spans.size());
	}
	
	/* Question 3 */
    @Test
	public void ButtonVisible() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='OPEN']/ancestor::a/following-sibling::p/following-sibling::div/button[.='Participate']")));
		List<WebElement> vis = driver.findElements(By.xpath("//a[@class='status']/span[.='OPEN']/ancestor::a/following-sibling::p/following-sibling::div/button[.='Participate']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='status']/span[.='OPEN']/ancestor::a/following-sibling::p/following-sibling::div/button[.='Participate']")));
		Boolean but=true;
		
		for(int j=0;j<vis.size();j++)
		{
			if(but==true)
			{
				but=vis.get(j).isEnabled();
				
			}
		}
		
		assertEquals("Matched", true,but);
	}
    
    /* Question 4*/
	@Test
	public void imageCheck() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[12]/div[1]/div[1]/div[2]/span/img")));
		WebElement ImageFile = driver.findElement(By.xpath("//*[@id='dynamicStudies']/div[12]/div[1]/div[1]/div[2]/span/img"));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		 if (!ImagePresent)
	        {
	             System.out.println("Image not displayed.");
	        }
	        else
	        {
	            System.out.println("Image displayed.");
	        }
		}
	}
	
	

