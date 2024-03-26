package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyRegAccPage extends BasePage{

	public MyRegAccPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") // MyAccount Page heading
	WebElement msgHeading;
	
	//@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")////div[@class ='dropdown']/ul/li/a[text()='Logout']
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")////a[@class='list-group-item'][normalize-space()='Logout']
	WebElement lnkLogout;
	
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			//return true;
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		clickMyAcc();
		lnkLogout.click();

	}
	
	public void clickMyAcc() {
		lnkMyaccount.click();

	}
}
