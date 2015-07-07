package deliverable3;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class CreateAccountTest {
	
	static WebDriver driver = new FirefoxDriver();	
	
	@Before
	public void setUp() throws Exception{
		driver.get("https://www.amazon.com/ap/register/ref=ap_register_mase_warn_change_email?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_youraccount_signout%26signIn%3D1%26useRedirectOnSuccess%3D1&prevRID=71WT9PDAC69S7AGQCBNX&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&emailNew=yufankaren%40gmal.com&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//driver.get("https://www.amazon.com");
			
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test	
	public void testInvalidEmail(){		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("ap_customer_name")).sendKeys("annie");
		driver.findElement(By.id("ap_email")).sendKeys("nnn");
		driver.findElement(By.id("ap_email_check")).sendKeys("nnn");
		driver.findElement(By.id("ap_password")).sendKeys("nnn");
		driver.findElement(By.id("ap_password_check")).sendKeys("nnn");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        WebElement registerBtn = driver.findElement(By.id("continue-input"));

		registerBtn.click();
		
		try {
			WebElement messageError = driver.findElement(By.id("message_error"));
			String elementText = messageError.getText();
			assertTrue(elementText.contains("email"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

	
	@Test	
	public void testInvalidPassword(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("ap_customer_name")).sendKeys("annie");
		driver.findElement(By.id("ap_email")).sendKeys("yufan0021@163.com");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("ap_email_check")).sendKeys("yufan0021@163.com");
		driver.findElement(By.id("ap_password")).sendKeys("1");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("ap_password_check")).sendKeys("1");
			
        WebElement registerBtn = driver.findElement(By.id("continue-input"));
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerBtn.click();
			
		try {
			WebElement messageError = driver.findElement(By.id("message_error"));
			String elementText = messageError.getText();
			assertTrue(elementText.contains("password requirements"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
