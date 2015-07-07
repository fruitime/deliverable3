package deliverable3;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class LogInTest {
	
	static WebDriver driver = new FirefoxDriver();	
	
	@Before
	public void setUp() throws Exception{
		driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_signin");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test	
	public void testValidLoginIn(){
		driver.findElement(By.name("email")).sendKeys("yufankaren@gmail.com");
		driver.findElement(By.name("password")).sendKeys("helloamazon");
		
        WebElement loginDiv = driver.findElement(By.id("ap_signin1a_signin_button_row"));
		
		WebElement submitButton = loginDiv.findElement(By.id("signInSubmit-input"));
		submitButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Check that there is a link to reset password and it is visible
		
		try {
			WebElement yourAccount = driver.findElement(By.id("nav-link-yourAccount"));
			assertTrue(yourAccount.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test	
	public void testInValidLoginIn(){
		driver.findElement(By.name("email")).sendKeys("yufankaren@gmail.com");
		driver.findElement(By.name("password")).sendKeys("hello");
		
        WebElement loginDiv = driver.findElement(By.id("ap_signin1a_signin_button_row"));
		
		WebElement submitButton = loginDiv.findElement(By.id("signInSubmit-input"));
		submitButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check that there is a link to reset password and it is visible
		
		try {
			System.out.println(driver.getPageSource());
			WebElement yourAccount = driver.findElement(By.id("message_error"));
			
			assertTrue(yourAccount.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
