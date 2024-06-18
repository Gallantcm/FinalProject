package Tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Store_Locator_Pg {
	WebDriver driver;
	WebDriverWait x;

	@FindBy(css = ".p1")
	WebElement storeLocatorSearchHeader;

	// Create constructor
	public Store_Locator_Pg(WebDriver driver) {
		this.driver = driver;
		this.x = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void checkPageText() {

		String actualLocatorHeader = storeLocatorSearchHeader.getText();

		// Assert that the loaded page displays specific text
		Assert.assertEquals(actualLocatorHeader, "Store Locator");

	}

	public void checkStoreLocatorPageText() {
		// TODO Auto-generated method stub
		
	}

}