package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']") // MyAccount Page heading
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
		lnkLogout.click();

	}
	
}
