package SeleniumFrameworkDesign.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
    WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(css=".ta-item:last-child")
	WebElement selectedCountry;
	By results=By.cssSelector(".ta-results");
	/*
	 * 	Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
		driver.findElement(By.cssSelector(".ta-item:last-child")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
	 */
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 */
		waitForElementToAppear(results);
	    
		selectedCountry.click();
		submit.click();
	
	}
	public ConfiramtionPage submitOrder()
	{
		submit.click();
		return new ConfiramtionPage(driver);
	}

}
