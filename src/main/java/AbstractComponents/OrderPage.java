package AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends AbstractComponents {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productNames;
	
	public Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match=productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

}
