package Scripts;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import BaseDriver.Base_Driver;

public class Search_Reseults_Pg extends Base_Driver{

	@Test
	public void searchForAnythingTest(Method method) {
		
		test = extent.createTest(method.getName());

		arrPg.enterSearchKey("Toys");
		arrPg.searchBTNClick();
		srchRPg.checkDiaperSearchHeader();
	}
}