package Scripts;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseDriver.Base_Driver;


public class Contact_Us_Pg extends Base_Driver {
	
	@Test(dataProvider = "email")
	public void emailValidation(Method method, String email) {
		test = extent.createTest(method.getName() + " - " + email);
		arrPg.clickContactUs();
		conUsPg.clickContactDetailsButton();
		conUsPg.validateEmailAddress(email);
	}

	@DataProvider(name = "email")
	public Object[][] emailData() {
		return new Object[][] { 
			// Right Email
			{ "customercare@firstcry.com" }, 
			// Wrong Email
			{ "incorrectemail@firstcry.com" } 
		};
	}
}