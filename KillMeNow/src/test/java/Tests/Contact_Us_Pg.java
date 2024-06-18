package Tests;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Contact_Us_Pg {
	WebDriver driver;
	WebDriverWait x;

	@FindBy(id = "contactdet")
	WebElement contactDetailsBtn;
	@FindBy(id = "customercare")
	WebElement customerCareAccordion;
	@FindBy(css = ".R16_link")
	WebElement customerCareEmail;


	public Contact_Us_Pg(WebDriver driver) {
		this.driver = driver;
		this.x = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	
	public void clickContactDetailsButton1() {

		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("arguments[0].scrollIntoView(true);", contactDetailsBtn);
		contactDetailsBtn.click();
	}

	public void validateEmailAddress1(String expectedEmailAddress) {

		customerCareAccordion.click();
		String actualEmail = customerCareEmail.getText();
		Assert.assertEquals(actualEmail, expectedEmailAddress);

	}

}
	public void clickContactDetailsButton() {
		// TODO Auto-generated method stub
		
	}

	public void validateEmailAddress(String email) {
		// TODO Auto-generated method stub
		
	}

}
