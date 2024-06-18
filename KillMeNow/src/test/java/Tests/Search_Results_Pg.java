package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Search_Results_Pg {

	WebDriver driver;
	WebDriverWait x;

	@FindBy(css = ".topl")
	WebElement Toys_Header;

	// Create constructor
	public Search_Results_Pg(WebDriver driver) {
		this.driver = driver;
		this.x = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void checkDiaperSearchHeader() {

		String actualResultsHeader = Toys_Header.getText();

		// Assert that the loaded page displays specific text
		Assert.assertTrue(actualResultsHeader.contains("Toys"));

	}

}