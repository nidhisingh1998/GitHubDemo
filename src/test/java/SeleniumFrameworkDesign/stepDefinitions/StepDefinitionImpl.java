package SeleniumFrameworkDesign.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumFrameworkDesign.pageobjects.CartPage;
import SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.pageobjects.ConfiramtionPage;
import SeleniumFrameworkDesign.pageobjects.LandingPage;
import SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import SeleniumFrameworkDesign.tests.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	ProductCatalogue productCatalogue;
	public LandingPage landingPage;
	CartPage cartpage;
	CheckoutPage checkoutPage;
	ConfiramtionPage confirmationpage;
	@Given("I landed on Ecommerce Page ")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		productCatalogue=landingpage.loginApplocation(username,password);
	}
	@When("^I_add_product (.+) to cart$")
	public void  I_add_product_to_cart(String productName)
	{
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
	}
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
	        cartpage=productCatalogue.goToCartpage();
			//CartPage cartpage=new CartPage(driver);
		    Boolean match=cartpage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			checkoutPage=cartpage.goToCheckout();
			checkoutPage.selectCountry("India");
			confirmationpage=checkoutPage.submitOrder();
	}
	@Then("{string} message is displayed  on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string)
	{
		String confirmMessage=confirmationpage.getConfiramationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		
	}
	@Then("{string} message is displayed")
	public void Error_message_is_displayed(String errorMessage)
	{
		Assert.assertEquals(errorMessage, landingpage.getErrorMessage());
		driver.close();
	}
	

}
