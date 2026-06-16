package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponents;

public class ConfiramtionPage extends AbstractComponents {

	WebDriver driver;
	public ConfiramtionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".hero-primary")
	WebElement ConfirmationMessage;
	
	
	
	/*
	 * String success=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(success);
		Assert.assertEquals(success, "THANKYOU FOR THE ORDER.");
	 */
	public String getConfiramationMessage()
	{
		return ConfirmationMessage.getText();
	}
	

}
