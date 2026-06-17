package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFrameworkDesign.pageobjects.CartPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeader;
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;

	public void waitForElementToAppear(By findBy)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement ele)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/*
	public CartPage goToCartpage()
	{
	    /*
         * 		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
         */
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //wait.until(ExpectedConditions.elementToBeClickable(CartHeader));
	/*
		CartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	
	}
*/
	public CartPage goToCartpage()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".ngx-spinner-overlay")));

	    wait.until(ExpectedConditions.elementToBeClickable(CartHeader));

	    CartHeader.click();

	    return new CartPage(driver);
	}
	public OrderPage goToMyOrderPage()
	{
	    /*
         * 		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
         */
	    OrderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	
	}
	public void waitForElementToDisappear(By findBy)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	/*
	 * public void waitForElementToDisappear(WebElement ele)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	 */
	
	

}
