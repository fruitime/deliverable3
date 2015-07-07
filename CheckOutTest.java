package deliverable3;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CheckOutTest {
    
    static WebDriver driver = new FirefoxDriver();  
    
    @Before
    public void setUp() throws Exception{
        driver.get("http://www.amazon.com/Meow-Mix-Chicken-Oceanfish-16-Pound/dp/B000R4CJQ2/ref=sr_1_1?&s=pet-supplies&ie=UTF8&qid=1435972088&sr=1-1&keywords=cat+food");
    }
    
    @Test   
    public void testAddOneItem(){       
            
        WebElement addCartBtn = driver.findElement(By.id("add-to-cart-button"));

        addCartBtn.click();
                
        try {
            WebElement message = driver.findElement(By.className("a-text-bold"));

            assertTrue(message.isDisplayed());
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }
    
    @Test
    public void deleteFromCart(){
        WebElement addCartBtn = driver.findElement(By.id("add-to-cart-button"));
        
        addCartBtn.click();
         
        WebElement cartBtn = driver.findElement(By.id("nav-cart"));

        cartBtn.click();
        
        WebElement deleteBtn = driver.findElement(By.name("submit.delete.C3GSZ6TFBDJIC"));
        deleteBtn.click();
         
        try {
            WebElement message = driver.findElement(By.className("a-size-base"));
            assertTrue(message.isDisplayed());
            } catch (NoSuchElementException nseex) {
                fail();
            }
    }
}
