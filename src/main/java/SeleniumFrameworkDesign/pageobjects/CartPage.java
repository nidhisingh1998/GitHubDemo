package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkoutEle;
	public Boolean VerifyProductDisplay(String productName)
	{
	    /*
         * 		List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		   		boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
				driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
         */
		 System.out.println("Expected Product : " + productName);

		    for(WebElement product : cartProducts)
		    {
		        System.out.println("Cart Product : " + product.getText());
		    }
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
	
		/*
		 * Checkout
		 * driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		 */
		checkoutEle.click();
		
		return new CheckoutPage(driver);
		
		
	}

}
