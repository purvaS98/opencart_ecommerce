package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"sanity","master"})
	public void verify_login() {
		
		//capturing logs
		logger.info("******Staring TC002 Login Test *******");
		logger.debug("Capturing Application debug logs");
		
		try {
			//Launch the application and go to Homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			//Login Page methods
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering Login credentials");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			logger.info("Clicked on Login button");
			lp.clickLogin();
			
			//Verify the login and go to My account to validate the login credentials
			MyAccountPage macc = new MyAccountPage(driver);
			
			boolean targetPage = macc.isMyAccountPageExists();
			
			if(targetPage == true) {
				logger.info("Login test Passed");
				Assert.assertTrue(true);
			}else {
				logger.info("Login test Failed");
				Assert.fail();
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****** TC002 Login Test Ends *******");
		
	}
}
