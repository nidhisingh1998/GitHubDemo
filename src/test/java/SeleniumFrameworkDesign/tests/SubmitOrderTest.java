package SeleniumFrameworkDesign.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractComponents.OrderPage;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import io.appium.java_client.functions.ExpectedCondition;

public class SubmitOrderTest extends BaseTest{
	String productName="IPHONE 13 PRO";
	@Test(dataProvider="getData", groups= {"purchaseOrder"})
	public void submitOrder(HashMap<String, String> input) throws IOException{
		// TODO Auto-generated method stub
		//String productName="IPHONE 13 PRO";
		//LandingPage landingpage=launchApplication();
		//login
		ProductCatalogue productCatalogue=landingpage.loginApplocation(input.get("email"), input.get("password"));
	    //ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	    List<WebElement> products = productCatalogue.getProductsList();
	    productCatalogue.addProductToCart(input.get("product"));
	    CartPage cartpage=productCatalogue.goToCartpage();
		//CartPage cartpage=new CartPage(driver);
	    Boolean match=cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartpage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfiramtionPage confirmationpage=checkoutPage.submitOrder();
	    String confirmMessage=confirmationpage.getConfiramationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.quit();
		

	}
	//Check order section afterb odering the product
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue=landingpage.loginApplocation("nidhi21@yopmail.com", "Nidhi@21");
		OrderPage orderpage=productCatalogue.goToMyOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
	
		//sending the data from json file
		List<HashMap<String, String>> data = getJsonDataToMap(
		        System.getProperty("user.dir")
		        + "//src//test//java//SeleniumFrameworkDesign//data//PurchaseOrder.json");
		 return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
		}
	/*//instead of sending Array we can sending Hashmap
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("email", "nidhi21@yopmail.com");
	map.put("password", "Nidhi@21");
	map.put("product", "IPHONE 13 PRO");
	HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("email", "nidhi12@yopmail.com");
	map1.put("password", "Nidhi@21");
	map1.put("product", "ZARA COAT 3");
	return new Object[][] {{map},{map1}};
 * 
 */
	
	/*
	 * @DataProvider
		public Object[][] getData()
		{
		return new Object[][] {{"nidhi21@yopmail.com", "Nidhi@21", "IPHONE 13 PRO"},{"nidhi12@yopmail.com","Nidhi@21", "ZARA COAT 3"}};
		
		}
	 */

}
