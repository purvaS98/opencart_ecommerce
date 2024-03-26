package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{

		
	@Test(groups = {"regression","master"})
	public void verify_acc_registration() {
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
			
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			String password="P1233";
			
			regpage.setPassword(password);
			//regpage.setTelephone(randomeNumber());
			
			
			//regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info(" Clicked on continue ");
			
			String confmsg=regpage.getConfirmationMsg();
			logger.info(" Validating expected message ");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.debug(" ------Application Logs Ends-------");
		logger.info("******** Completed TC_001_AccountRegsitrationTest ********");
		
	}
}
