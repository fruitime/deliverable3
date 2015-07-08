//User story: As a customer, I wan to search a product by keyword so that I can view related products and compare them.
//Scenario 1: Given Amazon.com opened and I am a customer who wants to buy some cat food, when I input cat food in the searching field, then the system will show related cat food. 
//Scenario 2: Given Amazon.com opened and I am a customer who is drunk, when I input some unreasonable thing, for instance, “nnknlnnfnsadlnfaengvdlngartee” in the searching field, then the system will display error message to show that the keywords does not match any result. 
package deliverable3;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

// Test search function by using reasonable search input and unreasonable search input
public class SearchTest {

	static WebDriver driver = new FirefoxDriver();		

	@Before
	public void setUp() throws Exception{
		driver.get("http://www.amazon.com/");
	}

	// Test if there any product pop out when user input "cat food" in search bar 
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

	// Test no product pop out when user input some unreasonable thing in search bar, like "nnknlnnfnsadlnfaengvdlngartee"
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

