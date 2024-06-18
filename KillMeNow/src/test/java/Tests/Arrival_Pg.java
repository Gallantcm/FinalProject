package Tests;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Arrival_Pg {
	WebDriver driver;
	WebDriverWait x;

	// Identify elements

	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/span/span")
	WebElement storesAndPreschoolsLink;

	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/a/span")
	WebElement findStoresLink;

	@FindBy(id = "search_box")
	WebElement searchBox;

	@FindBy(className = "search-button")
	WebElement searchBtn;

	@FindBy(linkText = "Contact Us")
	WebElement contactUsLink;

	// Constructor
	public Arrival_Pg(WebDriver driver) {
		this.driver = driver;
		this.x = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	// Define actions
	public void enterSearchKey1(String val) {
		searchBox.clear();
		searchBox.sendKeys(val);
	}

	public void searchBTNClick1() {
		searchBtn.click();
	}

	public void hoverAndClickFindStores1() throws InterruptedException { 
		
		Actions action = new Actions(driver);

		action.moveToElement(storesAndPreschoolsLink).perform();

		WebElement findStores = x.until(ExpectedConditions.visibilityOf(findStoresLink));
		x.until(ExpectedConditions.elementToBeClickable(findStoresLink));

		findStores.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public void clickContactUs1() {

		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("arguments[0].scrollIntoView(true);", contactUsLink);
		contactUsLink.click();
	}

	public void hoverAndClickFindStores() {
		// TODO Auto-generated method stub
		
	}

	public void searchBTNClick() {
		// TODO Auto-generated method stub
		
	}

	public void enterSearchKey(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickContactUs() {
		// TODO Auto-generated method stub
		
	}

}
