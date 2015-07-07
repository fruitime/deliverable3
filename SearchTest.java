package deliverable3;
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SearchTest {
	
	static WebDriver driver = new FirefoxDriver();		
	
	@Before
	public void setUp() throws Exception{
		driver.get("http://www.amazon.com/");
	}
	
	@Test	
	public void testValidSearch(){
		driver.findElement(By.name("field-keywords")).sendKeys("cat food");
		
        WebElement searchDiv1= driver.findElement(By.id("nav-search"));
        WebElement searchDiv2 = searchDiv1.findElement(By.className("nav-right"));
		WebElement submit = searchDiv2.findElement(By.className("nav-input"));
		submit.click();
		
		try {
			WebElement message = driver.findElement(By.id("s-result-count"));
			assertTrue(message.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test	
	public void testInValidSearch(){
       driver.findElement(By.name("field-keywords")).sendKeys("nnknlnnfnsadlnfaengvdlngartee");
       
       WebElement searchDiv1= driver.findElement(By.id("nav-search"));
       WebElement searchDiv2 = searchDiv1.findElement(By.className("nav-right"));
	   WebElement submit = searchDiv2.findElement(By.className("nav-input"));
	   submit.click();
	   
	   try {
			WebElement noResultsTitle= driver.findElement(By.id("noResultsTitle"));
			assertTrue(noResultsTitle.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}

