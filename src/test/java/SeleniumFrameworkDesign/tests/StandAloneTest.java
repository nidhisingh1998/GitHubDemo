package SeleniumFrameworkDesign.tests;

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
import io.appium.java_client.functions.ExpectedCondition;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new comment are added
		String productName="IPHONE 13 PRO";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		//LandingPage landingpage=new LandingPage(driver);
		//resistered
		//driver.findElement(By.cssSelector("text-reset")).click();
		//login
		driver.findElement(By.id("userEmail")).sendKeys("nidhi21@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nidhi@21");
		driver.findElement(By.cssSelector("#login")).click();

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		System.out.println(driver.findElement(By.cssSelector("#toast-container")).getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
	    //driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
		driver.findElement(By.cssSelector(".ta-item:last-child")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String success=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(success);
		Assert.assertEquals(success, "THANKYOU FOR THE ORDER.");
		driver.close();
		

	}

}
