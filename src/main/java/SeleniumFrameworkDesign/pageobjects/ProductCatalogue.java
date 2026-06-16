package SeleniumFrameworkDesign.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	/*
	 * 		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		This are comment utility thats why this is written on AbstractComponents class
		(Getting product list)
	*/
	@FindBy(css=".mb-3")
	List<WebElement> products;
	//@FindBy(css=".ng-animating")
	//WebElement loader;
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".btn.w-10.rounded");
	By toastMessage= By.cssSelector("#toast-container");
	By spinnerOverlay = By.cssSelector(".ngx-spinner-overlay");
	
	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	/*WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
	.equals(productName)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
    */
    public WebElement getProductByName(String productName)
    {
    	WebElement prod=getProductsList().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
    	return prod;
    }
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinnerOverlay);
		//waitForElementToDisappear(loader);
		
	}
}
