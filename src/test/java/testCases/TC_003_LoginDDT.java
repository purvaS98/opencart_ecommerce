package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) {
		
		logger.info("******Staring TC003 Login Data Driven Test *******");
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
			lp.setEmail(email);
			lp.setPassword(password);
			logger.info("Clicked on Login button");
			lp.clickLogin();
			logger.info("Login Button Clicked");
			
			//Verify the login and go to My account to validate the login credentials
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			// Passing valid data and checking target page is displayed or not
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					Thread.sleep(10);
					hp.clickMyAccount();
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					Thread.sleep(10);
					hp.clickMyAccount();
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("****** TC003 Login Data Driven Test Ends *******");
	}
}
