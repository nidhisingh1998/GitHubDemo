package SeleniumFrameworkDesign.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.pageobjects.CartPage;
import SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.pageobjects.ConfiramtionPage;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import SeleniumFrameworkDesign.tests.TestComponent.BaseTest;
import SeleniumFrameworkDesign.tests.TestComponent.Retry;
import io.appium.java_client.functions.ExpectedCondition;

public class ErrorValidation extends BaseTest{

	@Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException{
		// TODO Auto-generated method stub
		String productName="IPHONE 13 PRO";
		//LandingPage landingpage=launchApplication();
		//login
		landingpage.loginApplocation("nidhi@yopmail", "123456");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		
	   
		

	}
	@Test
	public void productErrorValidation() throws IOException{
		// TODO Auto-generated method stub
		String productName="IPHONE 13 PRO";
		//LandingPage landingpage=launchApplication();
		//login
		ProductCatalogue productCatalogue=landingpage.loginApplocation("nidhi21@yopmail.com", "Nidhi@21");
	    //ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	    List<WebElement> products = productCatalogue.getProductsList();
	    productCatalogue.addProductToCart(productName);
	    CartPage cartpage=productCatalogue.goToCartpage();
		//CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.VerifyProductDisplay("IPHONE 16 PRO");
		Assert.assertFalse(match);
		
		

	}


}
