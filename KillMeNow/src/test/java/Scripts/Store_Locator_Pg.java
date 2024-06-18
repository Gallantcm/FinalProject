package Scripts;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import BaseDriver.Base_Driver;

public class Store_Locator_Pg extends Base_Driver {
	@Test
	public void storesButtonClickTest(Method method) throws InterruptedException { 
		
		test = extent.createTest(method.getName());
		
		arrPg.hoverAndClickFindStores();
		strLPg.checkStoreLocatorPageText();
	}
}