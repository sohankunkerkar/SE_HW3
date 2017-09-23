All javascript/css/html pages are inside gh-pages branch and Selenium code is reference to master branch.

### Twitter Timline link:

[Twitter Timeline](https://pages.github.ncsu.edu/sakunker/HW3_sakunker/)

### Selenium Testing:
 
 1.The participant count of "Frustration of Software Developers" is 55
``` @Test 
	public void CheckCount() throws Exception
	{
		driver.get("http://www.checkbox.io/studies.html");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]")));
		WebElement check = driver.findElement(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dynamicStudies']/div[8]/div[2]/p/span[1]")));
		assertEquals("Matched","55", check.getText());
	}
```
2.The total number of studies closed is 5
```@Test
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
```
3.If a status of a study is open, you can click on a "Participate" button.
```	    @Test
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
		
		assertEquals("Matched",true,but);
	}
```
4.Check if the "Software Changes Survey" has a Amazon reward image

```@Test
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
```	
