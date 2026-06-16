package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	/*
	 * 	driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	 * driver.findElement(By.id("userEmail")).sendKeys("nidhi21@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nidhi@21");
		driver.findElement(By.cssSelector("#login")).click();
	 */
	
	@FindBy(id="userEmail")
	WebElement Username;
	@FindBy(id="userPassword")
	WebElement PasswordEle;
	@FindBy(css="#login")
	WebElement Submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMessage;
	
	public ProductCatalogue loginApplocation(String email,String password)
	{
		Username.sendKeys(email);
		PasswordEle.sendKeys(password);
		Submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	

}
