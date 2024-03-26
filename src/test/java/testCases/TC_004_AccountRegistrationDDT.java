package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyRegAccPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_AccountRegistrationDDT extends BaseClass{

	@Test(dataProvider = "RegData", dataProviderClass = DataProviders.class)
	public void verify_acc_registrationDDT(String fname, String lname, String email, String pass) {
		//logging the details of the test case
		//logger object created in BaseClass as it is the starting point for the exceution
		logger.info("******** Starting TC_001_AccountRegsitrationTest ********");
		
		//try block to catch any unexpected errors during test execution
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("******** Clicked on MyAccount Link ********");
			hp.clickRegister();
			
			//logger.info provide general info entered
			logger.info(" Clicked on Regsiteration Page ");
			
			//logger.debug captures the application logs
			logger.debug(" ------Application Logs Started-------");
			
			logger.info(" Entering customer details ");
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			regpage.setFirstName(fname);
			regpage.setLastName(lname);
			regpage.setEmail(email);
			//regpage.setTelephone(telPhone);
			
			//String password=randomAlphaNumeric();
			
			regpage.setPassword(pass);
			//regpage.setConfirmPassword(pass);
			
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info(" Clicked on continue ");
			
			//String confmsg=regpage.getConfirmationMsg();
			logger.info(" Validating expected message ");
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
			//Creating an object of My Registration Account page to validate the message on successful registration
			MyRegAccPage reg = new MyRegAccPage(driver);
			boolean regStatus = reg.isMyAccountPageExists();
			
			
			// Passing valid data and checking target page is displayed or not
			if(regStatus == true) {
				reg.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.debug(" ------Application Logs Ends-------");
		logger.info("******** Completed TC_001_AccountRegsitrationTest ********");
	}
}
